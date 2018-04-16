package org.es.com.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public abstract class ESClient {
	
	private static Client client;
	
	static {
		    Settings settings = Settings.settingsBuilder()
					.put("client.transport.sniff", true)
					//每两分钟将数据刷新到elasticsearch索引
					.put("index.refresh_interval", 120)
					//ES名称
					.put("cluster.name", Constant.getES_CLUSTERNAME())
					//副本
					.put("number_of_replicas", Integer.valueOf(Constant.getNUMBER_OF_REPLICAS()))
					//数据分片
					.put("number_of_shards", Integer.valueOf(Constant.getNUMBER_OF_SHARDS()))
					.build();
		    TransportClient transportClient = TransportClient.builder().settings(settings).build();
		    List<IpsPortBean> ipsPortBeans = Constant.getES_IP();
		    if(ipsPortBeans!=null&&!ipsPortBeans.isEmpty()){
		    	for (IpsPortBean ipsPortBean : ipsPortBeans) {
		    		try {
						transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ipsPortBean.getIp()),ipsPortBean.getPort()));
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}
				}
		    }
			client = transportClient;
	}

	public static Client getInstance() {
		return client;
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

}
