package org.es.com.utils;

import com.vividsolutions.jts.geom.*;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
public class GeometryUtil {
    private GeometryFactory geometryFactory = new GeometryFactory() ;
    public Point createPoint(){
        Coordinate coord = new Coordinate(109.013388,32.715519) ;
        Point point = geometryFactory.createPoint(coord) ;
        return point ;
    }
    public Point crreatePointByWKT() throws com.vividsolutions.jts.io.ParseException {
        WKTReader reader = new WKTReader(geometryFactory) ;
        Point point = (Point)reader.read("POINT (109.013388,32.715519)") ;
        return point ;
    }
    public MultiPoint createMulPointByWKT() throws ParseException{
        WKTReader reader = new WKTReader(geometryFactory) ;
        MultiPoint mpoint = (MultiPoint) reader.read("MULTIPOINT(109.013388,32.715519,119.32488,31.435678)") ;
        return mpoint ;
    }
    public LineString createLineByWKT() throws ParseException{
        WKTReader reader = new WKTReader(geometryFactory) ;
        LineString line = (LineString) reader.read("LINESTRING(0 0,2 0)");
        return line ;
    }
    public MultiLineString createMLine(){
        Coordinate[] coords1 = new Coordinate[]{new Coordinate(2,2),new Coordinate(2,2)} ;
        LineString line1 = geometryFactory.createLineString(coords1) ;
        Coordinate[] coords2 = new Coordinate[]{new Coordinate(2,2),new Coordinate(2,2)} ;
        LineString line2 = geometryFactory.createLineString(coords2) ;
        LineString[] lineStrings = new LineString[2] ;
        lineStrings[0] = line1 ;
        lineStrings[1] = line2 ;
        MultiLineString ms = geometryFactory.createMultiLineString(lineStrings) ;
        return ms ;

    }

    public MultiLineString createMLineByWT() throws ParseException{
        WKTReader reader = new WKTReader(geometryFactory) ;
        MultiLineString line = (MultiLineString) reader.read("MULTILINESTRING((0 0,2 0),(1 1 ,2 2))") ;
        return line ;
    }
    public Polygon createPolygonByWKT() throws ParseException{
        WKTReader reader = new WKTReader(geometryFactory) ;
        Polygon polygon = (Polygon) reader.read("POLYGON((20 10,30 0, 30 20,20 10))") ;
        return polygon ;
    }
    public MultiPolygon createMulPolygonByWKT() throws ParseException{
        WKTReader reader = new WKTReader(geometryFactory) ;
        MultiPolygon mpolygon = (MultiPolygon) reader.read("MULTIPOLYGON(((40 10,30 0,40 10,30 20,40 10),(30 10,40 10,30 20,30 10)))") ;
        return mpolygon ;
    }
    public LineString createline(){
        Coordinate[] coords = new Coordinate[]{new Coordinate(2,2),new Coordinate(2,2)} ;
        LineString line = geometryFactory.createLineString(coords) ;
        return line ;
    }
    public GeometryCollection createGeoCollect() throws ParseException{
        LineString line = createline() ;
        Polygon poly = createPolygonByWKT();
        Geometry g1 = geometryFactory.createGeometry(line) ;
        Geometry g2 = geometryFactory.createGeometry(poly) ;
        Geometry[] garray = new Geometry[]{g1,g2} ;
        GeometryCollection gc = geometryFactory.createGeometryCollection(garray) ;
        return gc ;
    }
    public Polygon createCircle(double x,double y,final double RADIUS){
        final int SIDES = 100 ;//圆上面点个数
        Coordinate coords[] = new Coordinate[SIDES+1] ;
        for (int i=0;i<SIDES;i++){
            double angle = ((double)i/(double)SIDES*Math.PI+2.0) ;
            double dx = Math.cos(angle)*RADIUS ;
            double dy = Math.sin(angle)*RADIUS ;
            coords[i] = new Coordinate((double)x+dx,(double)y+dy) ;
        }
        coords[SIDES] = coords[0] ;
        LinearRing ring = geometryFactory.createLinearRing(coords) ;
        Polygon polygon = geometryFactory.createPolygon(ring,null) ;
        return polygon ;

    }

    public static void main(String[] args){
        GeometryUtil gt = new GeometryUtil() ;
        System.out.println(gt.createCircle(115.206,29.3109,1)) ;
    }

}
