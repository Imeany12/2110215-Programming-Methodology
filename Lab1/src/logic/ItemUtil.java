package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import exception.NameBlankException;

public class ItemUtil {

	public static Scanner sc = new Scanner(System.in);

	public static boolean itemNameIsExist(Market market, String itemName) {
		// FILL CODE
		for (Item item : market.getAllItems()) {
			if (item.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;

	}

	public static boolean hasEnoughMoneytoBuy(Inventory toBuy, Item item, int amount) {
		// FILL CODE
		int pocket = toBuy.getMoney();
		int price = item.getPrice() * amount;
		if ((pocket - price) < 0) {
			return false;
		} else {
			return true;
		}

	}

	public static ArrayList<Item> getItemFromFile(String filename) {
		try {

			File fileToRead = new File(filename);
			ArrayList<Item> itemsFromFile = new ArrayList<Item>();

			// FILL CODE
			Scanner fileString = new Scanner(fileToRead);
			while (fileString.hasNextLine()) {
				String[] data = fileString.nextLine().split(" ");
				// System.out.println(Arrays.toString(data)); use this to turn array to string
				String itemName = data[0];// don't need "new" to assign variable at index 0
				try {

					int itemPrice = Integer.parseInt(data[1]);// this convert string to integer
					Item addItem = new Item(itemName, itemPrice);
					itemsFromFile.add(addItem);

				} catch (NameBlankException e) {
					fileString.close();
					System.out.println("Item name cannot be blank! This item will not be added.");

				}
			}
			return itemsFromFile;
		} catch (FileNotFoundException e) {
			System.out.println("Cannot found file!");

			return null;

		}
	}

	public static void playerSellplayer(Inventory toSell, Inventory toBuy, Item item, int amount) {
		if (!hasEnoughMoneytoBuy(toBuy, item, amount)) {
			System.out.println(toBuy.getPlayerName() + " dont't have enough money to buy this item.");
		} else {
			System.out.println("=========SELL CONFIRMATION=========");
			System.out.println("    Selling " + item.getItemName() + " x" + amount + " to " + toBuy.getPlayerName());
			System.out.println("            for $" + item.getPrice() * amount + "             ");
			System.out.println(" >> Type \"1\" to confirm selling  ");
			System.out.println(" >> Type anything else to cancel ");
			System.out.println("===================================");
			String input = sc.nextLine();
			switch (input) {
			case "1":
				playerSellPlayerConfirmed(toSell, toBuy, item, amount);
				System.out.println("<<TRANSACTION COMPLETE>>");
				break;
			default:
				System.out.println("<<SELL CANCEL>>");
				break;
			}
		}
	}

	public static void playerSellPlayerConfirmed(Inventory toSell, Inventory toBuy, Item item, int amount) {
		// FILL CODE
		toSell.setMoney(toSell.getMoney() + (item.getPrice() * amount));
		toBuy.setMoney(toBuy.getMoney() - (item.getPrice() * amount));
		toBuy.addItem(item, amount);
		toSell.removeItem(item, amount);

	}

	public static void playerSellMarket(Inventory toSell, Item item, int amount) {
		System.out.println("=========SELL CONFIRMATION=========");
		System.out.println("    Selling " + item.getItemName() + " x" + amount + " to market      ");
		System.out.println("            for $" + item.getPrice() * amount + "             ");
		System.out.println(" >> Type \"1\" to confirm selling  ");
		System.out.println(" >> Type anything else to cancel ");
		System.out.println("===================================");
		String input = sc.nextLine();
		switch (input) {
		case "1":
			playerSellMarketConfirmed(toSell, item, amount);
			System.out.println("<<TRANSACTION COMPLETE>>");
			break;
		default:
			System.out.println("<<SELL CANCEL>>");
			break;
		}
	}

	public static void playerSellMarketConfirmed(Inventory toSell, Item item, int amount) {
		// FILL CODE
		toSell.removeItem(item, amount);
		toSell.setMoney(toSell.getMoney() + (item.getPrice() * amount));
	}

	public static void playerBuyMarket(Inventory toBuy, Item item, int amount) {
		if (!ItemUtil.hasEnoughMoneytoBuy(toBuy, item, amount)) {
			System.out.println(toBuy.getPlayerName() + " Dont't have enough money\nto buy this item.");
		} else {
			System.out.println("=========BUY CONFIRMATION=========");
			System.out.println("	" + toBuy.getPlayerName() + " is buying ");
			System.out.println("	" + item.getItemName() + " x" + amount + " for $" + item.getPrice() * amount);
			System.out.println(" >> Type \"1\" to confirm buying  ");
			System.out.println(" >> Type anything else to cancel");
			System.out.println("==================================");
			String input = sc.nextLine();
			switch (input) {
			case "1":
				playerBuyMarketConfirmed(toBuy, item, amount);
				System.out.println("TRANSACTION COMPLETE!");
				break;
			default:
				System.out.println("BUY CANCEL!");
				break;
			}
		}
	}

	public static void playerBuyMarketConfirmed(Inventory toBuy, Item item, int amount) {
		// FILL CODE
		toBuy.setMoney(toBuy.getMoney() - (item.getPrice() * amount));
		toBuy.addItem(item, amount);
	}

}
