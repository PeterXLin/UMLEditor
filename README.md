# UML editor

> this project implements a UML editor using java swing

## GUI

### Tool Bar Area

- Edit
  - Group: 確認是否多於一個物件被 selected，if yes, group all selected object
  - Ungroup: 確認是否唯一個 composite object on selected, if yes ungroup 一層
  - change object name: 確認只有一個 basic object is selected, if yes, show a dialog to change object name

### Button Area

- mode: select, association line, generalization line, composition line, class, use case
- [ ] 使用 enum 宣告各種模式

- select mode

  - 物件 onClicked: 將其他物件取消選取，並渲染出自己的 connection ports
  - 背景被 onClicked: 將其他物件取消選取，紀錄起始點座標
  - 背景被 onReleased: 紀錄結束點座標，並 selected all objects in the rectangle

  - mouse pressed and released: 紀錄起始點和結束點座標，移動物件並重新連線

  - 目前想法: on select mode，when mouse is clicked，record the coordinate of the mouse, and check if there is any object is clicked

- association line mode

  - startObject: object
  - endObject: object
  - mouse pressed: 紀錄起始點座標，確認是否有選到物件，若有，則將該物件設為起始物件，若無，將起始物件設為 null

  - mouse released: 紀錄結束點座標，確認是否有選到物件，若有，則將該物件設為結束物件並連線，若沒有，則甚麼事情都不做

- generalization line mode

- composition line mode

  - [ ] 測試重疊物件被點擊的情況

- class mode
  - onclick: 將其他按鈕取消選取，button 變黑
  - canvas area onclick: 以 click 位置的(x, y)座標為左上角，產生一個 class object
- use case mode
  - onclick: 將其他按鈕取消選取，button 變黑
  - canvas area onclick: 以 click 位置的(x, y)座標為左上角，產生一個 class object

---

### Canvas Area[object]

==Variable==
**object list** : contain all object on canvas, sort by depth
==Function==
**draw** : draw all objects in canvas - [ ]確認位置移動的流程

#### 各個物件的功能

- object (最頂層的 object class)

  - depth: int
  - [ ] 確認用甚麼樣的 layout 比較好實作多層的功能

- basic object

  - onSelected: boolean

- class object and use case object

  - 先用一個 JLabel 就好，
    好像只能用兩個 JLabel 來實作，一個當背景圖片，一個當文字
  - getConnectionPoint(): 傳入點擊的座標點，回傳該點對應的 connection port coordinate

- connection line object

- composite object
  - [ ] 設計 composite object 移動時要如何一起動，可能用 box 之類的來包起來

#### 繼承架構圖

---

### 分檔

### 注意事項

==button 位置先固定，之後再改成相對位置(視窗大小改變時，button 位置也會改變)==

==物件深度不確定甚麼時候會更新，先不用管==
