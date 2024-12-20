package umc_7th.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc_7th.spring.domain.Mission;
import umc_7th.spring.domain.Review;
import umc_7th.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
    Page<Review> getReviewList(Long StoreId, Integer page);
    Page<Mission> getMissionList(Long StoreId, Integer page); // 2. 특정 가게의 미션 목록 조회하기 API
}
