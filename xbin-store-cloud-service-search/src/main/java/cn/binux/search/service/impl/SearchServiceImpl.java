package cn.binux.search.service.impl;

import cn.binux.pojo.SearchResult;
import cn.binux.pojo.SolrItem;
import cn.binux.pojo.XbinResult;
import cn.binux.search.mapper.SearchMapper;
import cn.binux.search.service.SearchService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Solr Service 实现类
 *
 * @author xubin.
 * @create 2017-05-03
 */

@RestController
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;

  /*  @Autowired
    private SolrClient solrClient;*/

    private static Logger logger = LoggerFactory.getLogger(SearchServiceImpl.class);

    @Override
    @ApiOperation("初始化solr数据 导入全部商品数据")
    @ApiResponses({ @ApiResponse(code = 200, message = "Successful — 请求已完成"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
        @ApiResponse(code = 500, message = "服务器不能完成请求") })
    public XbinResult importAllItems() {

        List<SolrItem> solrItemList = searchMapper.getSolrItemList();

        try {
            for (SolrItem solrItem : solrItemList) {

              /*  SolrInputDocument document = new SolrInputDocument();

                document.addField("id", solrItem.getId());
                document.addField("item_category_name", solrItem.getCategory_name());
                document.addField("item_title", solrItem.getTitle());

                String image = solrItem.getImage();
                String[] split = image.split(",");

                document.addField("item_image", split[0]);
                document.addField("item_price", solrItem.getPrice());
                document.addField("item_sell_point", solrItem.getSell_point());
                document.addField("item_desc", solrItem.getItem_desc());*/

               // solrClient.add(document);

            }

           // solrClient.commit();

            logger.info("import success num {}", solrItemList.size());
        } catch (Exception e) {
            logger.error("import error", e);
        }

        return XbinResult.ok();
    }

    @Override
    @ApiOperation("搜索商品")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "queryString", value = "", required = true, dataType = "String"),
        @ApiImplicitParam(name = "page", value = "", required = true, dataType = "Integer"),
        @ApiImplicitParam(name = "rows", value = "", required = true, dataType = "Integer") })
    @ApiResponses({ @ApiResponse(code = 200, message = "Successful — 请求已完成"),
        @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
        @ApiResponse(code = 401, message = "未授权客户机访问数据"),
        @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
        @ApiResponse(code = 500, message = "服务器不能完成请求") })
    public SearchResult search(@RequestParam("q") String queryString,
                               @RequestParam(defaultValue = "1") Integer page,
                               @RequestParam(defaultValue = "0") Integer rows) {

        SearchResult searchResult = new SearchResult();


        return searchResult;

    }
}
