import java.util.ArrayList;
import java.util.Scanner;

//模拟网上购物系统
public class ShoppingMian {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Shopping> list = new ArrayList<Shopping>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("************************");
		System.out.println("1.添加商品");
		System.out.println("2.查看所有商品");
		System.out.println("3.查看指定商品");
		System.out.println("4.删除指定商品");
		System.out.println("5.修改指定商品");
		System.out.println("6.退出系统");
		System.out.println("************************");
		// 使用do-while死循环
		do {
			// 得到用户输入的数字
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				add();// 添加商品
				break;
			case 2:
				selectAll();// 查询所有商品
				break;
			case 3:
				selectByName();// 通过名字查询商品
				break;
			case 4:
				delete();// 删除商品
				break;
			case 5:
				updateByName();// 根据名字更新商品
				break;
			case 6:// 退出系统
				exit();
				break;
			default:
				System.out.println("输入有误，请重新输入！");
				break;
			}
		} while (true);
	}

	private static void exit() {
		// TODO Auto-generated method stub
		System.out.println("欢迎再次使用，再见！");
		System.exit(0);
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("请输入需要删除商品的名称：");
		String inputName=input.next();
		int index=getIndex(inputName);
		if (index==-1) {
			System.out.println("您输入的商品名称不存在，删除失败！");
		}else {
			list.remove(index);
			System.out.println("删除成功！");
		}
	}

	private static void updateByName() {
		// TODO Auto-generated method stub
		System.out.println("请输入需要查询商品的名称：");
		String name=input.next();
		int index=getIndex(name);
		if (index==-1) {
			System.out.println("你输入的商品名称不存在，修改失败！");
		}else {
			System.out.println("请输入商品的价格：");
			int price=input.nextInt();
			System.out.println("请输入商品的数量：");
			int count=input.nextInt();
			Shopping shopping=list.get(index);
			shopping.setCount(count);
			shopping.setPrice(price);
			System.out.println(name+"商品信息修改成功！");
		}
	}

	private static void selectByName() {
		// TODO Auto-generated method stub
		System.out.println("请输入需要查询商品的名称：");
		String inputName=input.next();
		for(Shopping shopping:list) {
			String name=shopping.getName();
			if (name.equals(inputName)) {
				System.out.println(shopping);
				break;
			}
		}
	}

	private static void selectAll() {
		// TODO Auto-generated method stub
		for (Shopping shopping : list) {
			System.out.println(shopping);
		}
	}

	private static void add() {
		// TODO Auto-generated method stub
		System.out.println("请输入商品名称");
		String name = input.next();
		System.out.println("请输入商品价格");
		int price = input.nextInt();
		System.out.println("请输入商品数量");
		int count = input.nextInt();
		Shopping shopping = new Shopping(name, price, count);
		list.add(shopping);
	}
	
	private static int getIndex(String name) {
		int index=-1;
		for (int i = 0; i < list.size(); i++) {
			Shopping shopping=list.get(i);
			String name2=shopping.getName();
			if (name2.equals(name)) {
				index=i;
				break;
			}
		}
		return index;
	}
}
