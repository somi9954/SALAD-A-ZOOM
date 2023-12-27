package salad_a_zoom.api.board.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;


import java.util.UUID;

@Getter
public record BoardForm(
        Long seq,

        String bId,

        String gid,

        String category,

        @AssertTrue
        boolean notice,

        @NotBlank
        String subject,

        String guestPw,

        @NotBlank
        String poster,

        @NotBlank
        String content
) {

        public String getGid() {
                return (gid == null) ? UUID.randomUUID().toString() : gid;
        }
}