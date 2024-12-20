package umc_7th.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc_7th.spring.domain.Mission;
import umc_7th.spring.domain.Review;
import umc_7th.spring.domain.Store;
import umc_7th.spring.repository.MissionRepository;
import umc_7th.spring.repository.ReviewRepository;
import umc_7th.spring.repository.StoreRepository.StoreRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findStore(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float score) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, score);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }
    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
    @Override
    public Page<Mission> getMissionList(Long StoreId, Integer page) { // 2. 특정 가게의 미션 목록 조회하기 API
        Store store = storeRepository.findById(StoreId).get();

        Page<Mission> MissionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return MissionPage;
    }
}
