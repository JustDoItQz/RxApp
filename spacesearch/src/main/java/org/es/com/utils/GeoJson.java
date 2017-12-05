package org.es.com.utils;

import com.vividsolutions.jts.geom.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GeoJson {
    public static Logger logger = LoggerFactory.getLogger(GeoJson.class) ;
    private GeometryFactory geometryFactory ;
    public GeoJson(){
        this.geometryFactory = new GeometryFactory() ;
    }
    public Object parse(String json) throws IOException{

        JSONObject _obj = JSONObject.fromObject(json) ;
        if (_obj.has("type")==false){
            throw  new UnsupportedOperationException("no type attribute") ;
        }
        String _type = _obj.getString("type") ;
        if (_type.equals("Point")){
            _type.equalsIgnoreCase("LineString") ;
            _type.equalsIgnoreCase("Polygon") ;
            _type.equalsIgnoreCase("MultiPoint") ;
            _type.equalsIgnoreCase("MultiLineString") ;
            _type.equalsIgnoreCase("MultiPolygon") ;
            return this.parseGeometry(_obj) ;
        }else if (_type.equalsIgnoreCase("GeometryCollection")){
            this.parseGeometryCollection(_obj) ;
        }
        throw new UnSuppportedGeoJSONType(_type) ;
    }
    public GeometryCollection parseGeometryCollection(JSONObject obj) throws UnSuppportedGeoJSONType{
        if (obj.getString("type").equals("GeometryCollection")){
            throw new UnsupportedOperationException("Not GeometryCollection type") ;
        }
        JSONArray _list = obj.getJSONArray("members") ;
        Geometry[] _cols = new Geometry[_list.size()] ;
        for (int i=0;i<_cols.length;i++){
            _cols[i] = this.parseGeometry(_list.getJSONObject(i)) ;
        }
        return this.geometryFactory.createGeometryCollection(_cols) ;
    }


    public Geometry parseGeometry(JSONObject obj) throws UnSuppportedGeoJSONType{
        if (obj.has("type")==false){
            throw new UnSuppportedGeoJSONType("no type attribute") ;
        }
        String _type = obj.getString("type") ;
        if (_type.equalsIgnoreCase("Point")){
            return this.parsePoint(obj) ;
        }else if (_type.equalsIgnoreCase("LineString")){
            return this.parseLineString(obj) ;
        }else if (_type.equalsIgnoreCase("Polygon")){
            return this.parsePolygon(obj) ;
        }else if (_type.equalsIgnoreCase("MultiPoint")){
            return this.parseMultiPoint(obj) ;
        }else if (_type.equalsIgnoreCase("MultiLineString")){
            return this.parseMultiLineString(obj) ;
        }else if (_type.equalsIgnoreCase("MultiPolygon")){
            return this.parseMultiPolygon(obj) ;
        }
        throw new UnSuppportedGeoJSONType(_type) ;

    }
    public Point parsePoint(JSONObject obj){
        return this.parseCoordinatePoint(obj.getJSONArray("coordinates")) ;
    }
    public LineString parseLineString(JSONObject obj){
        return this.parseCoordinateLineString(obj.getJSONArray("coordinates")) ;
    }
    public Polygon parsePolygon(JSONObject obj){
        return this.parseCoordinatePolygon(obj.getJSONArray("coordinates")) ;
    }
    public MultiPoint parseMultiPoint(JSONObject obj){
        return this.geometryFactory.createMultiPoint(this.parseCoordinates(obj.getJSONArray("coordinates"))) ;
    }
    public MultiLineString parseMultiLineString(JSONObject obj){
        JSONArray _c = obj.getJSONArray("coordinates") ;
        LineString[] _lines = new LineString[_c.size()] ;
        for (int i=0;i<_lines.length;i++){
            _lines[i]=this.parseCoordinateLineString(_c.getJSONArray(i)) ;
        }
        return this.geometryFactory.createMultiLineString(_lines) ;
    }
    public MultiPolygon parseMultiPolygon(JSONObject obj){
        JSONArray _c = obj.getJSONArray("coordinates") ;
        Polygon[] _polys = new Polygon[_c.size()] ;
        for (int i=0;i<_polys.length;i++){
            _polys[i] = this.parseCoordinatePolygon(_c.getJSONArray(i)) ;
        }
        return this.geometryFactory.createMultiPolygon(_polys) ;
    }

    /*public GeometryCollection parseGeometryCollection(JSONObject obj)throws UnSuppportedGeoJSONType{
        if (obj.getString("type").equals("GeometryCollection")==false){
            throw new UnsupportedOperationException("Not GeometryCollection type") ;
        }
        JSONArray _list = obj.getJSONArray("members") ;
        Geometry[] _cols = new Geometry[_list.size()] ;
        for (int i=0;i<_cols.length;i++){
            _cols[i]=this.parseGeometry(_list.getJSONObject(i)) ;
        }
        return this.geometryFactory.createGeometryCollection(_cols) ;
    }*/


    protected Coordinate parseCoordinate(JSONArray obj){
        if (obj.size()<2){
            throw new IndexOutOfBoundsException("Not enougn coordinates") ;
        }
        return new Coordinate(obj.getDouble(0),obj.getDouble(1)) ;
    }
    protected Coordinate[] parseCoordinates(JSONArray obj){
        Coordinate[] _cs = new Coordinate[obj.size()] ;
        for (int i=0;i<obj.size();i++){
            _cs[i] = this.parseCoordinate(obj.getJSONArray(i)) ;
        }
        return _cs ;
    }

    protected Point parseCoordinatePoint(JSONArray obj){
        return this.geometryFactory.createPoint(this.parseCoordinate(obj)) ;
    }
    protected LineString parseCoordinateLineString(JSONArray obj){
        return this.geometryFactory.createLineString(this.parseCoordinates(obj)) ;
    }
    protected LinearRing parseCoordinateLineRing(JSONArray obj){
        return this.geometryFactory.createLinearRing(this.parseCoordinates(obj))  ;
    }
    protected Polygon parseCoordinatePolygon(JSONArray obj){
        if (obj.size()<0){
            throw new IndexOutOfBoundsException("Not enough line string") ;
        }
        LinearRing _out = this.parseCoordinateLineRing(obj.getJSONArray(0)) ;
        LinearRing[] _inners = new LinearRing[obj.size()-1] ;
        for (int i=0;i<_inners.length;i++){
            _inners[i] = this.parseCoordinateLineRing(obj.getJSONArray(i+1)) ;
        }
        return this.geometryFactory.createPolygon(_out,_inners) ;
    }

    protected int evaluateSimpleType(String val){
        if (Pattern.matches("\\d+",val)){
            return 0 ;
        }else if (Pattern.matches("\\d*\\.\\d*",val)){
            return 1 ;
        }
        return 2 ;
    }
    protected JSONArray encodeCoordinate(Coordinate c){
        double [] _pts = new double[]{c.x,c.y} ;
        return JSONArray.fromObject(_pts) ;
    }
    public JSONArray encodeCoordinates(Coordinate[] cs){
        JSONArray[] _list = new JSONArray[cs.length] ;
        for (int i=0;i<_list.length;i++){
            _list[i] = this.encodeCoordinate(cs[i]) ;
        }
        return JSONArray.fromObject(_list) ;
    }
    public JSONObject encodePoint(Point pt){
        JSONObject _obj = new JSONObject() ;
        _obj.put("type","Point") ;
        _obj.put("coordinates",this.encodeCoordinate(pt.getCoordinate())) ;
        return _obj ;
    }
    public JSONObject encodeLineString(LineString line){
        JSONObject _obj = new JSONObject() ;
        _obj.put("type","LineString") ;
        _obj.put("coordinates",this.encodeCoordinate(line.getCoordinate())) ;

        return _obj ;
    }
    public JSONObject encodePolygon(Polygon polygon){
        List<JSONArray> _lines = new ArrayList<JSONArray>() ;
        _lines.add(this.encodeCoordinate(polygon.getExteriorRing().getCoordinate())) ;
        for (int i=0;i<polygon.getNumInteriorRing();i++){
            _lines.add(this.encodeCoordinate(polygon.getInteriorRingN(i).getCoordinate())) ;
        }
        JSONObject _obj = new JSONObject() ;
        _obj.put("type","Polygon") ;
        _obj.put("coordinates",JSONArray.fromObject(_lines)) ;
        return _obj ;
    }
    public JSONObject encodeMultPoint(MultiPoint pts){
        JSONObject _obj = new JSONObject() ;
        _obj.put("type","MultiPoint") ;
        _obj.put("coordinates",this.encodeCoordinates(pts.getCoordinates())) ;
        return _obj ;
    }
    public JSONObject encodeMultiLineString(MultiLineString lines){
        List<JSONArray> _list = new ArrayList<JSONArray>() ;
        for (int i=0;i<lines.getNumGeometries();i++){
            _list.add(this.encodeCoordinates(lines.getGeometryN(i).getCoordinates())) ;
        }
        JSONObject _obj = new JSONObject() ;
        _obj.put("type","MultiLineString") ;
        _obj.put("coordinates",JSONArray.fromObject(_list.toArray())) ;
        return _obj ;
    }
    public JSONObject encodeMultiPolygon(MultiPolygon polygons){
        JSONArray[] _polygons = new JSONArray[polygons.getNumGeometries()] ;
        for (int i=0;i<polygons.getNumGeometries();i++){
            Polygon _polygon = (Polygon) polygons.getGeometryN(i) ;
            JSONArray[] _lines = new JSONArray[_polygon.getNumInteriorRing()+1] ;
            _lines[0] = this.encodeCoordinates(_polygon.getExteriorRing().getCoordinates()) ;

            for (int j=0;j<_polygon.getNumInteriorRing();i++){
                _lines[j+1] = this.encodeCoordinates(_polygon.getInteriorRingN(j).getCoordinates()) ;
            }
            _polygons[i] = JSONArray.fromObject(_lines) ;
        }
        JSONObject _obj = new JSONObject() ;
        _obj.put("type","MultiPolygon") ;
        _obj.put("coordinates",JSONArray.fromObject(_polygons)) ;
        return _obj ;
    }
    public JSONObject encodeGeometry(Geometry geo) throws UnSuppportedGeoJSONType{
        if (geo instanceof Point){
            return this.encodePoint((Point) geo) ;
        }else if (geo instanceof LineString){
            return this.encodeLineString((LineString) geo) ;
        }else if (geo instanceof Polygon){
            return this.encodePolygon((Polygon) geo) ;
        }else if (geo instanceof MultiPoint){
            return this.encodeMultPoint((MultiPoint)geo) ;
        }else if (geo instanceof MultiLineString){
            return this.encodeMultiLineString((MultiLineString)geo) ;
        }else if (geo instanceof MultiPolygon){
            return this.encodeMultiPolygon((MultiPolygon) geo) ;
        }
        throw new UnSuppportedGeoJSONType(geo.getGeometryType()) ;
    }
}
