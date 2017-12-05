package org.gisoper.com.test;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.NoNodeAvailableException;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class TestExample {

    public static void main(String[] args) throws UnknownHostException {
        InetSocketTransportAddress transportAddress = new InetSocketTransportAddress(
                InetAddress.getLocalHost(), 9300);
        createClientPrintResponse("getLocalHost", transportAddress);

        transportAddress = new InetSocketTransportAddress(
                InetAddress.getByName("localhost"), 9300);

        createClientPrintResponse("getByName(\"localhost\")", transportAddress);
//Does not compile in ElasticSearch 2.0
//        transportAddress = new InetSocketTransportAddress("localhost", 9200);
//        createClientPrintResponse("getByName(\"localhost\")", transportAddress);

        transportAddress = new InetSocketTransportAddress(
                InetAddress.getByAddress(new byte[]{127, 0, 0, 1}), 9200);
        createClientPrintResponse("getByAddress(new byte[] {127, 0, 0, 1})", transportAddress);

        transportAddress =
                new InetSocketTransportAddress(new InetSocketAddress("127.0.0.1", 9300));
        createClientPrintResponse("InetSocketAddress", transportAddress);
    }

    private static void createClientPrintResponse(String description,
                                                  InetSocketTransportAddress transportAddress) {
        Settings settings = Settings.builder()
                .put("cluster.name", "epsteinj-elasticsearch-local").build();
        Client client;
        client = new PreBuiltTransportClient(settings).addTransportAddress(transportAddress);
        try {
            GetResponse response = client.prepareGet("comicbook", "superhero", "1").get();
            System.out.println(description + ": " + response);
        } catch (NoNodeAvailableException e) {
            System.out.println(description + ": " + e);
            //e.printStackTrace();
        }
    }
}
