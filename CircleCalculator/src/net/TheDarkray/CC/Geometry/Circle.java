package net.TheDarkray.CC.Geometry;

/**
 * Created by Dani on 10.09.2016.
 */
public class Circle {

    // CALCULATION FUNCTIONS

    private double calcDiameter(double r) {
        return 2*r;
    }

    private double calcPerimeter(double r) {
        return Math.PI*2*r;
    }

    private double calcPerimeter(double r, double delta) {
        return (r*Math.PI*delta)/(180);
    }

    private double calcArea(double r) {
        return r*r*Math.PI;
    }

    private double calcArea(double r, double delta) {
        return (r*r*Math.PI*delta)/(360);
    }

    private double calcSin(double delta) {
        return Math.sin(Math.toRadians(delta));
    }

    private double calcCos(double delta) {
        return Math.cos(Math.toRadians(delta));
    }

    private double calcTan(double delta) {
        return Math.tan(Math.toRadians(delta));
    }

    // ATTRIBUTES

    double centerAngle;
    double radius;
    double diameter;
    double perimeter;
    double area;
    double sin;
    double cos;
    double tan;


    // CONSTRUCTORS

    public Circle() {
        this.centerAngle = 360;
        this.radius = 1;
        this.diameter = calcDiameter(1);
        this.perimeter = calcPerimeter(1);
        this.area = calcArea(1);
        this.sin = calcSin(1);
        this.cos = calcCos(1);
        this.tan = calcTan(1);
    }

    public Circle(double radius) {
        this.centerAngle = 360;
        this.radius = radius;
        this.diameter = calcDiameter(radius);
        this.perimeter = calcPerimeter(radius);
        this.area = calcArea(radius);
        this.sin = calcSin(this.centerAngle);
        this.cos = calcCos(this.centerAngle);
        this.tan = calcTan(this.centerAngle);
    }

    public Circle(double radius, double delta) {
        this.centerAngle = delta;
        this.radius = radius;
        this.diameter = calcDiameter(radius);
        this.perimeter = calcPerimeter(radius);
        this.area = calcArea(radius);
        this.sin = calcSin(this.centerAngle);
        this.cos = calcCos(this.centerAngle);
        this.tan = calcTan(this.centerAngle);
    }


    // GETTER / SETTER

    public double getCenterAngle() {
        return this.centerAngle;
    }

    public void setCenterAngle(double delta) {
        this.centerAngle = delta;
        this.perimeter = calcPerimeter(this.radius, delta);
        this.area = calcArea(this.radius, delta);
        this.sin = calcSin(this.centerAngle);
        this.cos = calcCos(this.centerAngle);
        this.tan = calcTan(this.centerAngle);
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        this.diameter = calcDiameter(radius);
        this.perimeter = calcPerimeter(radius, this.centerAngle);
        this.area = calcArea(radius, this.centerAngle);
    }

    public double getDiameter() {
        return this.diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
        this.radius = diameter/2;
        this.perimeter = calcPerimeter(this.radius, this.centerAngle);
        this.area = calcArea(this.radius, this.centerAngle);
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
        this.radius = perimeter/(2*Math.PI);
        this.diameter = calcDiameter(this.radius);
        this.area = calcArea(this.radius, this.centerAngle);
    }

    public void setPerimeter(double perimeter, double delta) {
        this.centerAngle = delta;
        this.perimeter = perimeter;
        this.radius = perimeter/(2*Math.PI);
        this.diameter = calcDiameter(this.radius);
        this.area = calcArea(this.radius, this.centerAngle);
        this.sin = calcSin(this.centerAngle);
        this.cos = calcCos(this.centerAngle);
        this.tan = calcTan(this.centerAngle);
    }

    public double getArea() {
        return this.area;
    }

    public void setArea(double area) {
        this.area = area;
        this.radius = Math.sqrt(area/Math.PI);
        this.diameter = calcDiameter(this.radius);
        this.perimeter = calcPerimeter(this.radius, this.centerAngle);
    }

    public void setArea(double area, double delta) {
        this.centerAngle = delta;
        this.area = area;
        this.radius = Math.sqrt(area/Math.PI);
        this.diameter = calcDiameter(this.radius);
        this.perimeter = calcPerimeter(this.radius, this.centerAngle);
        this.sin = calcSin(this.centerAngle);
        this.cos = calcCos(this.centerAngle);
        this.tan = calcTan(this.centerAngle);
    }

    public double getSin() {
        return this.sin;
    }

    public double getCos() {
        return this.cos;
    }

    public double getTan() {
        return this.tan;
    }

    public void set(String attribute, double value) {
        switch (attribute) {
            case "centerAngle": setCenterAngle(value); break;
            case "radius": setRadius(value); break;
            case "diameter": setDiameter(value); break;
            case "perimeter": setPerimeter(value, this.centerAngle); break;
            case "area": setArea(value, this.centerAngle); break;
        }
    }

}
