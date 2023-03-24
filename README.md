# UML editor

> this project implements a UML editor using java swing

## GUI

### Tool Bar Area

> Object: MenuItem extends GUIComponent

- Edit
  - Group: 確認是否多於一個物件被 selected，if yes, group all selected object
  - Ungroup: 確認是否唯一個 composite object on selected, if yes ungroup 一層
  - change object name: 確認只有一個 basic object is selected, if yes, show a dialog to change object name

### Button Area

> Object:
> ToggleButton extends GUIComponent

- mode(預設 mode 為 select): select, association line, generalization line, composition line, class, use case

- [x] 使用 enum 宣告各種模式

- [x] 要如何只讓一個 button on click -> 可以用 button group

---

### Canvas Area

> Object:
> MyCanvas extends GUIComponent

⭐**Variable**
**object list** : contain all object on canvas, sort by depth

⭐**Function**

#### Canvas Mode

- select mode

  - 物件 onClicked: 將其他物件取消選取，並渲染出自己的 connection ports
  - 背景被 onClicked: 將其他物件取消選取，紀錄起始點座標
  - 背景被 onReleased: 紀錄結束點座標，並 selected all objects in the rectangle

  - mouse pressed and released: 紀錄起始點和結束點座標，移動物件並重新連線

  - 目前想法: 用 getComponentAt()確認點擊到的物件，再做出相對應的動作

- association line mode

  - startObject: object
  - endObject: object
  - mouse pressed: 紀錄起始點座標，確認是否有選到物件，若有，則將該物件設為起始物件，若無，將起始物件設為 null

  - mouse released: 紀錄結束點座標，確認是否有選到物件，若有，則將該物件設為結束物件並連線，若沒有，則甚麼事情都不做

- generalization line mode

- composition line mode

  - [ ] 測試重疊物件被點擊的情況 -> 好像用一般的 panel 就好，

```java
lblNewLabel_1.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		panel_1.setComponentZOrder(lblNewLabel_1, 0);
		panel_1.repaint();
  }
});
```

- class mode
  - canvas area onclick: 以 click 位置的(x, y)座標為左上角，產生一個 class object
- use case mode
  - canvas area onclick: 以 click 位置的(x, y)座標為左上角，產生一個 class object

#### 各個物件的功能

- object (最頂層的 object class)

  - depth: int -> 好像不用，設個 Position 就好
  - [ ] 確認用甚麼樣的 layout 比較好實作多層的功能 -> 目前想法是用 JPanel 來實作

- basic object

  - onSelected: boolean

- class object and use case object

  - 先用一個 JLabel 就好，
    好像只能用兩個 JLabel 來實作，一個當背景圖片，一個當文字
  - getConnectionPoint(): 傳入點擊的座標點，回傳該點對應的 connection port coordinate

- connection line object

  - [x] 思考需不需要有這個 object，或是直接記 connection 關係就好 -> 直接記 connection 關係就好，畫線用 Graphics2D 畫

- composite object
  善用 components.getParent()來取得 parent，and find some
  - [ ] 設計 composite object 移動時要如何一起動，可能用 box 之類的來包起來

#### 繼承架構圖

---

### 分檔

### 注意事項

**button 位置先固定，之後再改成相對位置(視窗大小改變時，button 位置也會改變)**

**物件深度不確定甚麼時候會更新，先不用管**

JPanel.getComponentAt()
