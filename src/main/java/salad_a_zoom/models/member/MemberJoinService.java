package salad_a_zoom.models.member;

import salad_a_zoom.api.members.dto.RequestJoin;
import salad_a_zoom.api.members.validator.JoinValidator;
import salad_a_zoom.commons.constants.MemberType;
import salad_a_zoom.entities.Member;
import salad_a_zoom.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
@RequiredArgsConstructor
public class MemberJoinService {
    private final MemberRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JoinValidator validator;

    public void save(RequestJoin join, Errors errors) {
        validator.validate(join, errors);
        if (errors.hasErrors()) {
            return;
        }

        save(join);
    }

    public void save(RequestJoin join) {
        String password = passwordEncoder.encode(join.password());
        String mobile = join.mobile();
        if (mobile != null) mobile = mobile.replaceAll("\\D", "");
        Member member = Member.builder()
                .email(join.email())
                .password(password)
                .name(join.name())
                .mobile(mobile)
                .type(MemberType.USER)
                .build();
        save(member);
    }

    public void save(Member member) {
        System.out.println(member);
        repository.saveAndFlush(member);
    }
}