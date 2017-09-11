package org.es.com.utils;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by on 2017/6/26.
 * Author Aaron.Wang
 */
public  abstract class ESClient {
    private static Client client ;

    static {
        Settings settings = Settings.builder()
                .put("client.transport.sniff",true)
                .put("cluster.name","es-5.0-dev")
                .build() ;

        TransportClient transportClient = new PreBuiltTransportClient(settings) ;
        try {
            transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.2.86"),9300)) ;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        client = transportClient ;
    }
    public static Client getInstance(){
        return client ;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

}
