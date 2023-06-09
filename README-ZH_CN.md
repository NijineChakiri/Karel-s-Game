# 卡雷尔游戏
我的卡雷尔游戏(Java 实现)

## 游戏流程

开始游戏后，进入选关界面，此时可选择是否输入姓名学号，可输入Q退出游戏，若输入N跳过则默认使用 anonymous, 1234567 开始游戏。

![image-20230409153027132](C:\Users\14212\AppData\Roaming\Typora\typora-user-images\image-20230409153027132.png)

更改个人信息后需要选择地图。目前有三张地图可选，分别是 STAGE1, STAGE2 和 STAGE3 注意地图名称要全部大写，否则无法识别，可输入Q退出游戏。

选择玩地图后进入游戏界面，可输入指令操作人物移动，达到某条件时游戏胜利或失败（详见[游戏机制](#game_mechanics)）

:heart:祝游玩愉快！:heart:

## <span id="game_mechanics">游戏机制</span>

### 地块

地图上的每格都是一个地块，不同的地块会有不同的效果，以下是目前的地块列表：

|     名称     |  形态   |                             描述                             |
| :----------: | :-----: | :----------------------------------------------------------: |
|   **人物**   | ►/▲/◄/▼ |          显示**人物**当前所处位置，箭头指示当前朝向          |
|   **地面**   |    ·    |                      无特殊效果，可通行                      |
|   **墙壁**   |    ■    |                  不可通行，阻挡**人物**行进                  |
|   **石头**   |    ●    |             不可通行，阻挡**人物**行进，可被拾取             |
|   **陷阱**   |    ⊙    | 不可穿越，踩中或通过**陷阱**会困住**人物**并使游戏结束<br />可用**石头**填平，填平后变为*填平的陷阱* |
| *填平的陷阱* |    ×    |          **陷阱**填平后形成，无特殊效果，同**地面**          |
|    *路径*    |    *    |           指示玩家前往某地，无特殊效果，同**地面**           |

### 指令

玩家可通过输入指令来操纵角色或是获取信息等，以下是目前的指令列表：

|       名称        |                             功能                             |                 条件                 |
| :---------------: | :----------------------------------------------------------: | :----------------------------------: |
|         Q         |                           退出游戏                           |                  无                  |
|      move()       |                 使**人物**以当前朝向前进一格                 |         前方一格为可通行地块         |
|    move(int x)    |                使**人物**以当前朝向前进 x 格                 |       前方 x 格均为可通行地块        |
|    turnLeft()     |                        使**人物**左转                        |                  无                  |
|    turnRight()    |                        使**人物**右转                        |                  无                  |
| showInformation() | 显示信息，包括地图上剩余的**石头**数量、当前背包内**石头**数量和<br />离最近**石头**的距离（曼哈顿距离，不考虑障碍物） |                  无                  |
|    pickRock()     |               拾取面前一格的**石头**并放入背包               |            面前一格为石头            |
|     putRock()     |       拿出背包中的一块**石头**并填平面前一格的**陷阱**       | 背包内有**石头**且面前一格为**陷阱** |
|   noRockInBag()   |   检查背包内是否有**石头**，没有显示 true，否则显示 false    |                  无                  |
|  noRockPresent()  |  检查面前一格是否是**石头**，不是显示 true，否则显示 false   |                  无                  |
|   gameHelper()    |   找到一条连接当前位置和所有**石头**的*路径*（不一定最优）   |                  无                  |

**注意：输入指令区分大小写，应严格按照指令名称输入，否则会无法找到对应指令！**

## 背包

背包容量目前设置为无限。

## 胜利

拾取地图上所有**石头**则游戏胜利。

## 失败

**人物**被**陷阱**困住则游戏失败。

