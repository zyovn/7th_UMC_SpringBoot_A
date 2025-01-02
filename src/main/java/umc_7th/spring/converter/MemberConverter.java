package umc_7th.spring.converter;

import org.springframework.data.domain.Page;
import umc_7th.spring.domain.Member;
import umc_7th.spring.domain.Mission;
import umc_7th.spring.domain.Review;
import umc_7th.spring.domain.enums.Gender;
import umc_7th.spring.domain.mapping.MemberMission;
import umc_7th.spring.web.dto.MemberDTO.MemberRequestDTO;
import umc_7th.spring.web.dto.MemberDTO.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request) {

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .email(request.getEmail())   // 추가된 코드
                .password(request.getPassword())   // 추가된 코드
                .role(request.getRole())   // 추가된 코드
                .memberPreferList(new ArrayList<>())
                .build();
    }
    public static MemberResponseDTO.ReviewPreViewDTO myReviewPreViewDTO (Review review) {
        return MemberResponseDTO.ReviewPreViewDTO.builder()
                .nickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }
    public static MemberResponseDTO.ReviewPreViewListDTO myReviewPreViewListDTO (Page<Review> myReviewList) {
        List<MemberResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = myReviewList.stream()
                .map(MemberConverter::myReviewPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(myReviewList.isLast())
                .isFirst(myReviewList.isFirst())
                .totalPage(myReviewList.getTotalPages())
                .totalElement(myReviewList.getTotalElements())
                .ListSize(reviewPreViewDTOList.size())
                .myReviewList(reviewPreViewDTOList)
                .build();
    }
    public static MemberResponseDTO.MemberMissionPreviewDTO memberMissionPreviewDTO (MemberMission memberMission) { // 3. 내가 진행 중인 미션 목록 조회하기 API
        return MemberResponseDTO.MemberMissionPreviewDTO.builder()
                .storeName(memberMission.getMission().getStore().getName())
                .reward(memberMission.getMission().getReward())
                .status(memberMission.getStatus())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .deadline(memberMission.getMission().getDeadline())
                .createdAt(memberMission.getCreatedAt())
                .build();
    }
    public static MemberResponseDTO.MemberMissionPreviewListDTO memberMissionPreviewListDTO (Page<MemberMission> myMissionList) {
        List<MemberResponseDTO.MemberMissionPreviewDTO> memberMissionPreviewDTOList = myMissionList.stream()
                .map(MemberConverter::memberMissionPreviewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MemberMissionPreviewListDTO.builder()
                .isFirst(myMissionList.isFirst())
                .isLast(myMissionList.isLast())
                .totalPage(myMissionList.getTotalPages())
                .totalElement(myMissionList.getTotalElements())
                .ListSize(memberMissionPreviewDTOList.size())
                .myMissionList(memberMissionPreviewDTOList)
                .build();
    }
}
