package salad_a_zoom.api.members.dto;

import lombok.Builder;

@Builder
public record ResponseLogin(
        String accessToken
) {}