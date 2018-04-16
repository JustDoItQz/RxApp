package org.es.com.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.Polygon;

public class GeoHashGeometry {

	private int level;

	private int[] BITS = new int[] { 16, 8, 4, 2, 1 };

	private static char[] BASE32_CHARS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'm', 'n','p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public GeoHashGeometry(int level) {
		this.level = level;
	}

	private String[] getSubGeoHash(String geohash) {
		String[] subGeoHashs = new String[BASE32_CHARS.length];
		for (int i = 0; i < BASE32_CHARS.length; i++) {
			subGeoHashs[i] = geohash + BASE32_CHARS[i];
		}
		return subGeoHashs;
	}

	public List<String> encode(Geometry geometry,boolean inclParents) {
		if (geometry instanceof Point) {
			String geohash=encodeGeoHash(((Point) geometry).getX(), ((Point) geometry).getY(), level);
			//是否包含副节点geohash
			if(!inclParents){
				return Collections.singletonList(geohash);
			}
			List<String> goeHashs = new ArrayList<String>(level);
			for (int i = 1; i <= geohash.length(); i++) {
				goeHashs.add(geohash.substring(0, i));
			}
			return goeHashs;
		}
		List<String> geoHashs = new ArrayList<String>();
		matchGeometry(new String(), geometry, geoHashs,inclParents);
		return geoHashs;
	}
	
	public String encodePoint(Point geometry) {
		String geohash=encodeGeoHash(((Point) geometry).getX(), ((Point) geometry).getY(), level);
		return geohash;
	}
	
	
	/**
	 * 此方法不支持点的子geohash计算
	 * @param geohash
	 * @param geometry
	 * @param inclParents
	 * @return
	 */
	public List<String> encodeSubChild(String geohash,Geometry geometry,boolean inclParents) {
		List<String> goeHashs = new ArrayList<String>();
		matchGeometry(geohash, geometry, goeHashs,inclParents);
		return goeHashs;
	}

	private void matchGeometry(String geohash, Geometry geometry, List<String> geoHashs,boolean inclParents) {
		if (geohash.length() < level) {
			String[] subChilds = getSubGeoHash(geohash);
			for (int i = 0; i < subChilds.length; i++) {
				double[] d = decodeGeoHash(subChilds[i]);
				Polygon polygon = new GeometryFactory().createPolygon(new Coordinate[] { new Coordinate(d[0], d[2]), new Coordinate(d[1], d[2]),
						new Coordinate(d[1], d[3]), new Coordinate(d[0], d[3]), new Coordinate(d[0], d[2]) });
				if (geometry.intersects(polygon)) {
					if(inclParents){
						geoHashs.add(subChilds[i]);
					}else if(inclParents==false&&subChilds[i].length()==level){
						geoHashs.add(subChilds[i]);
					}
					matchGeometry(subChilds[i], geometry, geoHashs,inclParents);
				}
			}
		}
	}

	private double[] decodeGeoHash(String geohash) {
		double lonRange[] = { -180, 180 };
		double latRange[] = { -90, 90 };
		boolean isEven = true;
		for (int i = 0; i < geohash.length(); ++i) {
			char c = geohash.charAt(i);

			int dec = decode(c);
			for (int bit : BITS) {
				if (isEven) {
					if ((dec & bit) != 0) {
						lonRange[0] = (lonRange[0] + lonRange[1]) / 2.0;
					} else {
						lonRange[1] = (lonRange[0] + lonRange[1]) / 2.0;
					}
				} else {
					if ((dec & bit) != 0) {
						latRange[0] = (latRange[0] + latRange[1]) / 2.0;
					} else {
						latRange[1] = (latRange[0] + latRange[1]) / 2.0;
					}
				}
				isEven = !isEven;
			}
		}
		return new double[] { lonRange[0], lonRange[1], latRange[0], latRange[1] };
	}
	
	private String encodeGeoHash(double lon, double lat, int level) {
		String hash = "";
		double lonRange[] = { -180, 180 };
		double latRange[] = { -90, 90 };
		boolean isEven = true;
		int bits = 0;
		int count = 0;
		while (hash.length() < level) {
			if (isEven) {
				double middle = (lonRange[0] + lonRange[1]) / 2.0;
				if (lon > middle) {
					bits |= BITS[count];
					lonRange[0] = middle;
				} else {
					lonRange[1] = middle;
				}
			} else {
				double middle = (latRange[0] + latRange[1]) / 2.0;
				if (lat > middle) {
					bits |= BITS[count];
					latRange[0] = middle;
				} else {
					latRange[1] = middle;
				}
			}
			isEven = !isEven;
			if (count < 4) {
				count++;
			} else {
				hash += BASE32_CHARS[bits];
				bits = 0;
				count = 0;
			}
		}
		return hash;
	}

	private int decode(char geo) {
		switch (geo) {
		case '0':
			return 0;
		case '1':
			return 1;
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case 'b':
			return 10;
		case 'c':
			return 11;
		case 'd':
			return 12;
		case 'e':
			return 13;
		case 'f':
			return 14;
		case 'g':
			return 15;
		case 'h':
			return 16;
		case 'j':
			return 17;
		case 'k':
			return 18;
		case 'm':
			return 19;
		case 'n':
			return 20;
		case 'p':
			return 21;
		case 'q':
			return 22;
		case 'r':
			return 23;
		case 's':
			return 24;
		case 't':
			return 25;
		case 'u':
			return 26;
		case 'v':
			return 27;
		case 'w':
			return 28;
		case 'x':
			return 29;
		case 'y':
			return 30;
		case 'z':
			return 31;
		default:
			return -1;
		}
	}

	
}
