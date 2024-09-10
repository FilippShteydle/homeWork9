package com.shteydle.top.homeWork9;

/*Королю нужно убить дракона, но в его казне мало средств для покупки армии. Нужно создать программу, используя
методы, которая поможет рассчитать минимальное количество копейщиков, которое необходимо, чтобы убить
дракона. C клавиатуры вводятся данные:
■ здоровья дракона;
■ атаки дракона;
■ здоровье одного копейщика;
■ атака одного копейщика.
Защита, меткость и т. п. не учитывать. Копейщики наносят удар первыми (общий нанесенный урон – это сумма атак
всех живых копейщиков). Если атака дракона превышает значение жизни копейщика (например, у копейщика жизни – 10,
а атака – 15), то умирает несколько копейщиков, а оставшийся урон идет одному из копейщиков.
Например, жизнь дракона – 500, атака – 55, жизнь одного копейщика – 10, атака –10, а количество копейщиков при
данных условиях – 20. Лог боя для данного примера должен выглядеть так:
Итерация 15 Копейщики атакуют (урон 200) – у дракона осталось 300 жизней
Дракон атакует – осталось 15 копейщиков, один из которых ранен (осталось 5 жизней)
Копейщики атакуют – у дракона осталось 150 жизней
Дракон атакует – осталось 9 копейщиков
Копейщики атакуют – у дракона осталось 60 жизней
Дракон атакует – осталось 4 копейщика, один из которых ранен (осталось 5 жизней)
Копейщики атакуют – у дракона осталось 20 жизней
Дракон атакует и побеждает*/

public class Task05 {

    public static void killDragon (int healthDragon, int attackDragon, int healthSoldier, int attackSoldier) {

        boolean flag = false;
        boolean flagAttack = false;

        for (int i = 15; i < healthDragon / attackSoldier; i++) {
            int n = i;
            int healthWoundSoldier;
            int health = healthDragon;
            int allAttackSoldier = !flagAttack ? attackSoldier * n : attackSoldier * (n - 1);
            int allHealthSoldier = !flagAttack ? healthSoldier * n : healthSoldier * (n - 1);

            if (!flagAttack) {
                while (healthDragon > 0) {
                    healthDragon = healthDragon - allAttackSoldier;
                    if (healthDragon <= 0) {
                        flagAttack = true;
                        healthDragon = health;
                        break;
                    }
                    healthWoundSoldier = (allHealthSoldier - attackDragon) % healthSoldier;
                    if (healthWoundSoldier != 0) {
                        n = (allHealthSoldier - attackDragon) / healthSoldier + 1;
                        allHealthSoldier = healthSoldier * (n - 1) + healthWoundSoldier;
                    } else {
                        n = (allHealthSoldier - attackDragon) / healthSoldier;
                        allHealthSoldier = healthSoldier * n;
                    }
                    if (n < 0) {
                        healthDragon = health;
                        break;
                    }
                    allAttackSoldier = attackSoldier * n;
                }
            } else {

                while (healthDragon > 0) {
                    healthDragon = healthDragon - allAttackSoldier;
                    System.out.println("Коппейщики атакуют (урон " + allAttackSoldier + (healthDragon > 0 ? ") - у дракона осталось " + healthDragon + " жизней" : ") Дракон мертв"));
                    if (healthDragon <= 0) {
                        flag = true;
                        break;
                    }
                    healthWoundSoldier = (allHealthSoldier - attackDragon) % healthSoldier;
                    if (healthWoundSoldier != 0) {
                        n = (allHealthSoldier - attackDragon) / healthSoldier + 1;
                        allHealthSoldier = healthSoldier * (n - 1) + healthWoundSoldier;
                        System.out.println("Дракон атакует - осталось " + n + " Коппейщиков, один из которых ранен (осталось " + healthWoundSoldier + " жизней)");
                    } else {
                        n = (allHealthSoldier - attackDragon) / healthSoldier;
                        allHealthSoldier = healthSoldier * n;
                        System.out.println(n > 0 ? "Дракон атакует - осталось " + n + " Коппейщиков" : "Дракон атакует - все копейщики мертвы");
                    }
                    allAttackSoldier = attackSoldier * n;
                }
                System.out.println(flag ? "Победили копейщики, их осталось " + n : "Дракон победил");
                System.out.println("Для победы над Драконом необходимо " + (i - 1) + " коппейщиков");
            }
            if (flag) break;
        }
    }
}
