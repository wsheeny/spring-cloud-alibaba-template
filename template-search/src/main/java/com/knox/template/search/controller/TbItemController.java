package com.knox.template.search.controller;


import com.knox.template.commons.domain.TbItemEntity;
import com.knox.template.commons.mapper.TbBrandMapper;
import com.knox.template.commons.mapper.TbItemMapper;
import com.knox.template.search.BrandRepository;
import com.knox.template.search.ItemRepository;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.join.query.JoinQueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * item商品表 前端控制器
 * </p>
 *
 * @author knox
 * @since 2020-12-20
 */
@RestController
@RequestMapping("/item")
public class TbItemController {

    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Autowired
    private TbItemMapper tbItemMapper;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public void importAll() {
        // 查询数据库使用商品
        // 索引到ES
        itemRepository.saveAll(tbItemMapper.selectList(null));

        brandRepository.saveAll(tbBrandMapper.selectList(null));
    }

    @GetMapping("/search")
    public Page<TbItemEntity> searchByTitle(int pageIndex, int pageSize) {
        // 查询参数
        QueryBuilder queryBuilder = JoinQueryBuilders.hasChildQuery("item",
                QueryBuilders.matchQuery("title", "小米"), ScoreMode.Max);
        Pageable pageable = PageRequest.of(pageIndex, pageSize);

        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(queryBuilder).withPageable(pageable).build();
        Page<TbItemEntity> search = itemRepository.search(build);
        return search;
    }

}
