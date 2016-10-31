package com.marutian.qwer;

import java.util.List;

/**
 * Copyright 2016 Marutian. All rights reserved.
 *
 * @author Shin Gwangsu (maruroid@gmail.com)
 * @since 2016. 10. 31.
 */
public class Vita500 {
    public String name;
    public int kcal;
    public int carbohydrate;
    public int protein;
    public int fat;
    public String img;
    public List<MenuList> menuList;

    public class MenuList {
        public String name;
        public int price;
        public String size;
    }

}
