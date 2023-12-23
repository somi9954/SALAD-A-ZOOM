package salad_a_zoom.api.members;

import salad_a_zoom.api.commons.JSONData;
import salad_a_zoom.api.members.dto.RequestJoin;
import salad_a_zoom.api.members.dto.RequestLogin;
import salad_a_zoom.api.members.dto.ResponseLogin;
import salad_a_zoom.commons.Utils;
import salad_a_zoom.commons.exceptions.BadRequestException;
import salad_a_zoom.configs.jwt.CustomJwtFilter;
import salad_a_zoom.entities.Member;
import salad_a_zoom.models.member.MemberInfo;
import salad_a_zoom.models.member.MemberInfoService;
import salad_a_zoom.models.member.MemberJoinService;
import salad_a_zoom.models.member.MemberLoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberLoginService loginService;
    private final MemberInfoService infoService;
    private final MemberJoinService joinService;

    /**
     * accessToken 발급
     *
     */
    @PostMapping("/token")
    public ResponseEntity<JSONData<ResponseLogin>> authorize(@Valid @RequestBody RequestLogin requestLogin, Errors errors) {
        // 유효성 검사 처리
        errorProcess(errors);

        ResponseLogin token = loginService.authenticate(requestLogin.email(), requestLogin.password());

        HttpHeaders headers = new HttpHeaders();
        headers.add(CustomJwtFilter.AUTHORIZATION_HEADER, "Bearer " + token.accessToken());

        JSONData<ResponseLogin> data = new JSONData<>(token);

        return ResponseEntity.status(data.getStatus())
                .headers(headers)
                .body(data);
    }


    /**
     * 회원가입 처리
     *
     * @return
     */
    @PostMapping
    public ResponseEntity<JSONData<Object>> join(@RequestBody @Valid RequestJoin form, Errors errors) {

        joinService.save(form, errors);

        // 유효성 검사 처리
        errorProcess(errors);

        HttpStatus status = HttpStatus.CREATED;
        JSONData<Object> data = new JSONData<>();
        data.setSuccess(true);
        data.setStatus(status);

        return ResponseEntity.status(status).body(data);
    }

    private void errorProcess(Errors errors) {
        if (errors.hasErrors()) {
            Map<String, List<String>> errorMessages = Utils.getMessages(errors);
            throw new BadRequestException(errorMessages);
        }
    }

    @GetMapping("/info")
    public JSONData<Member> info(@AuthenticationPrincipal MemberInfo memberInfo) {
        Member member = memberInfo == null ? null : memberInfo.getMember();
        JSONData<Member> data = new JSONData<>(member);
        data.setSuccess(member != null);

        return data;
    }

    @GetMapping("/member_only")
    public void MemberOnlyUrl() {
        log.info("회원 전용 URL 접근 테스트");
    }

    @GetMapping("/admin_only")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void adminOnlyUrl() {
        log.info("관리자 전용 URL 접근 테스트");
    }
}