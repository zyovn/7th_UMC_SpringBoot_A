package umc_7th.spring.web.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc_7th.spring.domain.enums.MissionStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MemberResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinResultDTO{
        Long memberId;
        LocalDateTime createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewDTO {
        String nickname;
        Float score;
        String body;
        LocalDate createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewPreViewListDTO {
        List<ReviewPreViewDTO> myReviewList;
        Integer ListSize;
        Integer totalPage;
        Long totalElement;
        Boolean isFirst;
        Boolean isLast;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreviewDTO { // 3. 내가 진행 중인 미션 목록 조회하기 API
        String storeName;
        Integer reward;
        MissionStatus status;
        String missionSpec;
        LocalDate deadline;
        LocalDateTime createdAt;
    }
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreviewListDTO {
        List<MemberMissionPreviewDTO> myMissionList;
        Integer ListSize;
        Integer totalPage;
        Long totalElement;
        Boolean isFirst;
        Boolean isLast;
    }
}
