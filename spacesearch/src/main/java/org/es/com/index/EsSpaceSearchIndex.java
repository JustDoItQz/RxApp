package org.es.com.index;

import net.sf.json.JSONObject;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.es.com.constant.Config;
import org.es.com.utils.ESClient;

public class EsSpaceSearchIndex extends AbstractSpaceSearchIndex {

    private BulkRequestBuilder builder ;

    public EsSpaceSearchIndex(){
        init();
    }

    public void deleteDataStr(String dataset, String fromDate, String toDate) throws Exception {

        BoolQueryBuilder query = QueryBuilders.boolQuery() ;
        query.must(QueryBuilders.rangeQuery(Config.VEHICLETIME).gte(fromDate)) ;
        query.must(QueryBuilders.rangeQuery(Config.VEHICLETIME).lte(toDate)) ;
        SearchResponse result = ESClient.getInstance().prepareSearch(dataset).setTypes(Config.INDEX_GEO_TYPE).setQuery(query).addFieldDataField("_id").setSize(1000).get() ;
        SearchHit[] hits = result.getHits().getHits() ;
        if (hits.length>0){
            for (SearchHit hit:hits){
                builder.add(ESClient.getInstance().prepareDelete(dataset,Config.INDEX_GEO_TYPE,hit.getId())) ;
            }
            builder.get() ;
            deleteDataStr(dataset,fromDate,toDate);
        }
    }
    public void insert(String dataset, String id, Object[] header, Object[] values)throws Exception {
        if (ESClient.getInstance()!=null){
            JSONObject data = new JSONObject() ;
            for (int i=0;i<header.length;i++){
                data.put(header[i],values[i]) ;
            }
            bulkRequestBuilder(dataset,id,data.toString());
        }
    }

    public void bulkRequestBuilder(String dataset, String id, String data){
        UpdateRequest request = new UpdateRequest(dataset,"",id) ;
        request.doc(data.toString()).upsert(data.toString()) ;
        builder.add(request) ;
    }

    public void init() {
        builder = ESClient.getInstance().prepareBulk() ;
    }

    public void commit() {
        BulkResponse response = builder.execute().actionGet() ;
        if (response.hasFailures()){

        }
        builder = ESClient.getInstance().prepareBulk() ;

    }

    public void complete() {
        if (builder.numberOfActions()!=0){
            commit();
        }
    }

}
