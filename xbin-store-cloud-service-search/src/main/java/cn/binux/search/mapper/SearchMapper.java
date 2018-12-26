package cn.binux.search.mapper;

import cn.binux.pojo.SolrItem;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Solr操作Mapper
 *
 * @author xubin.
 * @create 2017-02-04 下午4:46
 */
@Component
public interface SearchMapper {

    List<SolrItem> getSolrItemList();

    SolrItem getSolrItemByItemId(long itemid);

}
