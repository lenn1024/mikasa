package ai.code.mikasa.test.builder;

import org.springframework.util.Assert;

public class City {
    private String name; // required
    private String road; // required
    private String water; // required

    private String tree; // optional

    private City(CityBuilder builder){
        this.name = builder.name;
        this.road = builder.road;
        this.water = builder.water;
        this.tree = builder.tree;
    }

    public static class CityBuilder implements Builder<City>{
        private String name; // required
        private String road; // required
        private String water; // required

        private String tree; // optional

        public CityBuilder name(String name){
            this.name = name;
            return this;
        }

        public CityBuilder road(String road){
            this.road = road;
            return this;
        }

        public CityBuilder water(String water){
            this.water = water;
            return this;
        }

        public CityBuilder tree(String tree){
            this.tree = tree;
            return this;
        }

        @Override
        public City build() {
            Assert.notNull(name);
            Assert.notNull(road);
            Assert.notNull(water);
            return new City(this);
        }
    }

    public static void main(String[] args){
        City city = new CityBuilder()
                .name("郑州")
                //.road("中山")
                .water("农夫山泉")
                .tree("银杏树")
                .build();

        System.out.println(city);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", road='" + road + '\'' +
                ", water='" + water + '\'' +
                ", tree='" + tree + '\'' +
                '}';
    }
}
