package com.plume.designPatterns.factoryMode;

import com.plume.designPatterns.factoryMode.factory.ChocolateFactory;
import com.plume.designPatterns.factoryMode.factory.DarkChocolateFactory;
import com.plume.designPatterns.factoryMode.factory.MilkChocolateFactory;
import com.plume.designPatterns.factoryMode.factory.WhiteChocolateFactory;
import com.plume.designPatterns.factoryMode.kind.Chocolate;

public class Client {
    public static void main(String[] args) {
        // 创建牛奶巧克力工厂
        ChocolateFactory milkFactory = new MilkChocolateFactory();
        // 生产牛奶巧克力
        Chocolate milkChocolate = milkFactory.makeChocolate();
        // 制作巧克力
        milkChocolate.make();

        // 创建黑巧克力工厂
        ChocolateFactory darkFactory = new DarkChocolateFactory();
        // 生产黑巧克力
        Chocolate darkChocolate = darkFactory.makeChocolate();
        // 制作巧克力
        darkChocolate.make();

        WhiteChocolateFactory factory = new WhiteChocolateFactory();
        Chocolate chocolate = factory.makeChocolate();
        chocolate.make();
    }
}
