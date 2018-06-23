import java.util.ArrayList;
import java.util.Scanner;

//ģ�����Ϲ���ϵͳ
public class ShoppingMian {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Shopping> list = new ArrayList<Shopping>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("************************");
		System.out.println("1.�����Ʒ");
		System.out.println("2.�鿴������Ʒ");
		System.out.println("3.�鿴ָ����Ʒ");
		System.out.println("4.ɾ��ָ����Ʒ");
		System.out.println("5.�޸�ָ����Ʒ");
		System.out.println("6.�˳�ϵͳ");
		System.out.println("************************");
		// ʹ��do-while��ѭ��
		do {
			// �õ��û����������
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				add();// �����Ʒ
				break;
			case 2:
				selectAll();// ��ѯ������Ʒ
				break;
			case 3:
				selectByName();// ͨ�����ֲ�ѯ��Ʒ
				break;
			case 4:
				delete();// ɾ����Ʒ
				break;
			case 5:
				updateByName();// �������ָ�����Ʒ
				break;
			case 6:// �˳�ϵͳ
				exit();
				break;
			default:
				System.out.println("�����������������룡");
				break;
			}
		} while (true);
	}

	private static void exit() {
		// TODO Auto-generated method stub
		System.out.println("��ӭ�ٴ�ʹ�ã��ټ���");
		System.exit(0);
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫɾ����Ʒ�����ƣ�");
		String inputName=input.next();
		int index=getIndex(inputName);
		if (index==-1) {
			System.out.println("���������Ʒ���Ʋ����ڣ�ɾ��ʧ�ܣ�");
		}else {
			list.remove(index);
			System.out.println("ɾ���ɹ���");
		}
	}

	private static void updateByName() {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ��ѯ��Ʒ�����ƣ�");
		String name=input.next();
		int index=getIndex(name);
		if (index==-1) {
			System.out.println("���������Ʒ���Ʋ����ڣ��޸�ʧ�ܣ�");
		}else {
			System.out.println("��������Ʒ�ļ۸�");
			int price=input.nextInt();
			System.out.println("��������Ʒ��������");
			int count=input.nextInt();
			Shopping shopping=list.get(index);
			shopping.setCount(count);
			shopping.setPrice(price);
			System.out.println(name+"��Ʒ��Ϣ�޸ĳɹ���");
		}
	}

	private static void selectByName() {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫ��ѯ��Ʒ�����ƣ�");
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
		System.out.println("��������Ʒ����");
		String name = input.next();
		System.out.println("��������Ʒ�۸�");
		int price = input.nextInt();
		System.out.println("��������Ʒ����");
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
