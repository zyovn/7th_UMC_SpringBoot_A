package umc_7th.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 756387610L;

    public static final QMember member = new QMember("member1");

    public final umc_7th.spring.domain.common.QBaseEntity _super = new umc_7th.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc_7th.spring.domain.enums.Gender> gender = createEnum("gender", umc_7th.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<umc_7th.spring.domain.mapping.MemberAgree, umc_7th.spring.domain.mapping.QMemberAgree> memberAgreeList = this.<umc_7th.spring.domain.mapping.MemberAgree, umc_7th.spring.domain.mapping.QMemberAgree>createList("memberAgreeList", umc_7th.spring.domain.mapping.MemberAgree.class, umc_7th.spring.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<umc_7th.spring.domain.mapping.MemberMission, umc_7th.spring.domain.mapping.QMemberMission> memberMissionList = this.<umc_7th.spring.domain.mapping.MemberMission, umc_7th.spring.domain.mapping.QMemberMission>createList("memberMissionList", umc_7th.spring.domain.mapping.MemberMission.class, umc_7th.spring.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc_7th.spring.domain.mapping.MemberPrefer, umc_7th.spring.domain.mapping.QMemberPrefer> memberPreferList = this.<umc_7th.spring.domain.mapping.MemberPrefer, umc_7th.spring.domain.mapping.QMemberPrefer>createList("memberPreferList", umc_7th.spring.domain.mapping.MemberPrefer.class, umc_7th.spring.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc_7th.spring.domain.enums.Role> role = createEnum("role", umc_7th.spring.domain.enums.Role.class);

    public final EnumPath<umc_7th.spring.domain.enums.SocialType> socialType = createEnum("socialType", umc_7th.spring.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc_7th.spring.domain.enums.MemberStatus> status = createEnum("status", umc_7th.spring.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

