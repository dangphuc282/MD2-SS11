import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Product> products = new HashMap<>();

        while (true) {
            System.out.println("\n====== MENU QUẢN LÝ SẢN PHẨM ======");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Lọc sản phẩm có giá > 100");
            System.out.println("6. Tính tổng giá trị sản phẩm");
            System.out.println("7. Thoát");
            System.out.print("Chọn chức năng: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Nhập ID sản phẩm: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        if (products.containsKey(id)) {
                            System.out.println("ID đã tồn tại.");
                            break;
                        }

                        System.out.print("Nhập tên sản phẩm: ");
                        String name = scanner.nextLine();

                        System.out.print("Nhập giá sản phẩm: ");
                        double price = Double.parseDouble(scanner.nextLine());

                        products.put(id, new Product(id, name, price));
                        System.out.println("Thêm sản phẩm thành công.");
                    } catch (NumberFormatException e) {
                        System.out.println("Dữ liệu nhập không hợp lệ.");
                    }
                    break;

                case "2":
                    try {
                        System.out.print("Nhập ID sản phẩm cần sửa: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        if (!products.containsKey(id)) {
                            System.out.println("Không tìm thấy sản phẩm với ID này.");
                            break;
                        }

                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nhập giá mới: ");
                        double newPrice = Double.parseDouble(scanner.nextLine());

                        Product product = products.get(id);
                        product.setName(newName);
                        product.setPrice(newPrice);

                        System.out.println("Cập nhật sản phẩm thành công.");
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi nhập liệu.");
                    }
                    break;

                case "3":
                    try {
                        System.out.print("Nhập ID sản phẩm cần xóa: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        if (products.remove(id) != null) {
                            System.out.println("Xóa thành công.");
                        } else {
                            System.out.println("Không tìm thấy sản phẩm.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID phải là số.");
                    }
                    break;

                case "4":
                    if (products.isEmpty()) {
                        System.out.println("Danh sách sản phẩm trống.");
                    } else {
                        products.values().forEach(Product::display);
                    }
                    break;

                case "5":
                    List<Product> filtered = products.values().stream()
                            .filter(p -> p.getPrice() > 100)
                            .collect(Collectors.toList());

                    if (filtered.isEmpty()) {
                        System.out.println("Không có sản phẩm nào giá > 100.");
                    } else {
                        filtered.forEach(Product::display);
                    }
                    break;

                case "6":
                    double total = products.values().stream()
                            .mapToDouble(Product::getPrice)
                            .sum();
                    System.out.println("Tổng giá trị sản phẩm: " + total);
                    break;

                case "7":
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
