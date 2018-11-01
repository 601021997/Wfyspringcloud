package builder;

public class MainClass {

    public static void main(String[] args) {
        House house = new House();
        house.setFloor("屋顶");
        house.setWall("墙壁");

        HouseBuilder builder = new GongYuBuilder();
        DireectBuider direectBuider = new DireectBuider();
        direectBuider.makeHouse(builder);

        House house1 = builder.getHouse();


    }

}
