package umc_7th.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc_7th.spring.domain.Member;
import umc_7th.spring.domain.Review;

import java.util.Optional;

public interface MemberQueryService {
    Optional<Member> findMember(Long id);
    Page<Review> getMyReviewList(Long memberId, Integer page);
}
