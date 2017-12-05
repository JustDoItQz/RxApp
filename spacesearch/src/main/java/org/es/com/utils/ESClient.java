package org.es.com.utils;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.es.com.vo.IpsPortBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.net.InetAddress;
import java.util.List;


/**
 * Created by on 2017/6/26.
 * Author Aaron.Wang
 */
public  abstract class ESClient {
    private static Logger logger = LoggerFactory.getLogger(ESClient.class) ;
    static TransportClient client = null;
    static {
       Settings settings = Settings.builder()
               .put("client.transport.sniff",false)
               .put("node.client",true)
               .put("cluster.name",Constant.getES_CLUSTERNAME())
               .put("index.refresh_interval",120)
               .put("node.name","es_node")
               .put("number_of_replicas",Integer.valueOf(Constant.getNUMBER_OF_REPLICAS()))
               .put("number_of_shards",Integer.valueOf(Constant.getNUMBER_OF_SHARDS()))
               .build() ;

        TransportClient preBuiltTransportClient = null;
        try {
            // 创建client
            preBuiltTransportClient = TransportClient.builder().settings(settings).build() ;
            List<IpsPortBean> ipsPortBeans = Constant.getES_IPS() ;
            if (ipsPortBeans!=null&&!ipsPortBeans.isEmpty()){
                for (IpsPortBean ipsPortBean:ipsPortBeans){
                    try{
                        client = preBuiltTransportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ipsPortBean.getIp()),ipsPortBean.getPort())) ;
                    }catch (Exception e){
                        e.printStackTrace();
                        logger.error("ES连接IP异常{}",e.getMessage());
                    }
                }
            }
            /* String token = basicAuthHeaderValue("test_user", new SecuredString("changeme".toCharArray()));
            client.filterWithHeader(Collections.singletonMap("Authorization", token));*/
        }catch (Exception e){
            e.printStackTrace();
            logger.error("启动ES异常：{}",e.getMessage());

        }

    }
    public static Client getInstance(){
        return client ;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}
