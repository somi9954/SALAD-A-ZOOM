package salad_a_zoom.models.member;

import salad_a_zoom.api.members.dto.ScheduleDto;
import salad_a_zoom.repositories.DiaryDataRepository;
import salad_a_zoom.repositories.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class DiaryService {

    private final DiaryDataRepository diaryRepository;
    private final MemberRepository memberRepository;

    public ScheduleDto save(ScheduleDto dto){


        return dto;
    }

}