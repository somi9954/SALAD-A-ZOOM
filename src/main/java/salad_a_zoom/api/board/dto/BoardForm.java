package salad_a_zoom.api.board.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;


public record BoardForm(

        String category,

        @NotBlank
        String subject,

        @NotBlank
        String poster,

        @NotBlank
        String content,

        @AssertTrue
        boolean notice,

        String guestPw

) {}
