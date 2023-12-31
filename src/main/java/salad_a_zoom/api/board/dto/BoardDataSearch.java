package salad_a_zoom.api.board.dto;

import lombok.Data;

@Data
public class BoardDataSearch {
    private String bId;
    private int page = 1;
    private int limit = 20;

    private String category;
    private String sopt;
    private String skey;
}
