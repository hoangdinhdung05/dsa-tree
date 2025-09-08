# Cấu trúc dữ liệu Cây (Tree Data Structure)

## 1. Giới thiệu
- Cây là một cấu trúc dữ liệu phi tuyến tính bao gồm các nút (nodes) được kết nối với nhau theo một cấu trúc phân cấp (cha-con). 
- Mỗi cây bao gồm một node gốc (root node) và các node con (child nodes) được kết nối với nhau thông qua các cạnh (edges).
- Cây thường được sử dụng để biểu diễn các cấu trúc dữ liệu như hệ thống tập tin, biểu thức toán học, và các cấu trúc phân cấp khác.

## 2. Thuật ngữ cơ bản
- **Node (Nút)**: Một phần tử trong cây, có thể chứa dữ liệu và các con trỏ đến các nút con.
- **Root (Gốc)**: Nút đầu tiên của cây, không có nút cha.
- **Parent (Cha)**: Nút có các nút con.
- **Child (Con)**: Nút con của một nút cha.
- **Leaf (Lá)**: Nút không có nút con.
- **Subtree (Cây con)**: Một phần của cây bao gồm một nút và tất cả các nút con của nó.
- **Height (Chiều cao)**: Số lượng cạnh dài nhất từ nút gốc đến một lá.
- **Depth (Độ sâu)**: Số lượng cạnh từ nút gốc đến nút hiện tại.

## 3. Các loại cây phổ biến
- **Binary Tree (Cây nhị phân): ** Mỗi nút có tối đa hai con.
- **Binary Search Tree (Cây tìm kiếm nhị phân): ** Một cây nhị phân mà trong đó nút con bên trái có giá trị nhỏ hơn nút cha và nút con bên phải có giá trị lớn hơn nút cha.
- **AVL Tree (Cây AVL): ** Một cây tìm kiếm nhị phân tự cân bằng, trong đó sự chênh lệch chiều cao giữa hai cây con của bất kỳ nút nào không vượt quá 1.
- **Red-Black Tree (Cây đỏ-đen): ** Một cây tìm kiếm nhị phân tự cân bằng với các quy tắc màu sắc để đảm bảo cân bằng.
- **Trie (Cây tiền tố): ** Một cây đặc biệt được sử dụng để lưu trữ một tập hợp các chuỗi, thường được sử dụng trong các ứng dụng tìm kiếm từ khóa.
- **Heap (Đống): ** Một cây nhị phân hoàn chỉnh mà trong đó giá trị của mỗi nút cha lớn hơn hoặc bằng (max-heap) hoặc nhỏ hơn hoặc bằng (min-heap) giá trị của các nút con.
- **B-tree (Cây B): ** Một cấu trúc dữ liệu cây tự cân bằng được sử dụng trong hệ quản trị cơ sở dữ liệu và hệ thống tập tin để lưu trữ và truy xuất dữ liệu một cách hiệu quả.
- **B+ tree (Cây B+): ** Một biến thể của cây B, trong đó tất cả các giá trị được lưu trữ ở các nút lá và các nút nội bộ chỉ chứa các khóa để hướng dẫn tìm kiếm.
- **Suffix Tree (Cây hậu tố): ** Một cấu trúc dữ liệu cây được
- **Segment Tree (Cây đoạn): ** Một cấu trúc dữ liệu cây được sử dụng để lưu trữ các đoạn của một mảng và hỗ trợ các truy vấn và cập nhật hiệu quả trên các đoạn này.
- **Fenwick Tree (Cây Fenwick) hoặc Binary Indexed Tree (Cây chỉ số nhị phân): ** Một cấu trúc dữ liệu cây được sử dụng để lưu trữ

## 4. Duyệt cây (Tree Traversal)
- **Pre-order Traversal (Duyệt trước): ** Truy cập nút gốc trước, sau đó duyệt cây con bên trái và cuối cùng là cây con bên phải.
- **In-order Traversal (Duyệt giữa): ** Duyệt cây con bên trái, truy cập nút gốc, sau đó duyệt cây con bên phải. Đối với cây tìm kiếm nhị phân, kết quả sẽ được sắp xếp theo thứ tự tăng dần.
- **Post-order Traversal (Duyệt sau): ** Duyệt cây con bên trái, sau đó cây con bên phải, và cuối cùng truy cập nút gốc.
- **Level-order Traversal (Duyệt theo cấp độ): ** Duyệt các nút theo từng cấp độ từ trên xuống dưới, từ trái sang phải.
- **Depth-First Search (DFS - Tìm kiếm theo chiều sâu): ** Duyệt cây bằng cách đi sâu vào từng nhánh trước khi quay lại.
- **Breadth-First Search (BFS - Tìm kiếm theo chiều rộng): ** Duyệt cây theo từng cấp độ, từ trên xuống dưới.

## 5. Thao tác với cây
- **Chèn (Insertion): ** Thêm một nút mới vào cây.
- **Xóa (Deletion): ** Loại bỏ một nút khỏi cây.
- **Tìm kiếm (Search): ** Tìm một nút trong cây dựa trên giá trị của nó.
- **Cân bằng (Balancing): ** Điều chỉnh cấu trúc của cây để đảm bảo hiệu suất tối ưu.
- **Tính chiều cao (Height Calculation): ** Xác định chiều cao của cây.
- **Tính kích thước (Size Calculation): ** Đếm số lượng nút trong cây.
- **Tìm kiếm phần tử lớn nhất/nhỏ nhất (Find Max/Min): ** Tìm giá trị lớn nhất hoặc nhỏ nhất trong cây.
- **Tìm kiếm phần tử kế tiếp/tiền nhiệm (Find Successor/Predecessor): ** Tìm nút kế tiếp hoặc tiền nhiệm trong cây tìm kiếm nhị phân
- **Tìm kiếm đường dẫn (Path Finding): ** Tìm đường dẫn từ nút gốc đến một nút cụ thể trong cây.
- **So sánh cây (Tree Comparison): ** So sánh hai cây để xác định xem chúng có giống nhau hay không.
- **Sao chép cây (Tree Cloning): ** Tạo một bản sao của cây hiện tại.
- **Xoay cây (Tree Rotation): ** Thực hiện các phép xoay để duy trì cân bằng trong các cây tự cân bằng như AVL và Red-Black Tree.
- **Tính toán chiều sâu (Depth Calculation): ** Xác định độ sâu của một nút cụ thể trong cây.
- **Tính toán số lượng lá (Leaf Count): ** Đếm số lượng nút lá trong cây.
- **Tìm kiếm phần tử theo điều kiện (Conditional Search): ** Tìm các nút thỏa mãn một điều kiện cụ thể trong cây.

## 6. Ứng dụng của cây
- **Hệ thống tập tin:** Cây được sử dụng để biểu diễn cấu trúc thư mục và tập tin trong hệ điều hành.
- **Cơ sở dữ liệu:** Cây B và B+ được sử dụng để lưu trữ và truy xuất dữ liệu một cách hiệu quả.
- **Trình biên dịch:** Cây cú pháp trừu tượng (Abstract Syntax Tree - AST) được sử dụng để biểu diễn cấu trúc ngữ pháp của mã nguồn.
- **Mạng máy tính:** Cây được sử dụng trong các thuật toán định tuyến và quản lý mạng.
- **Trò chơi:** Cây được sử dụng trong các thuật toán tìm kiếm như Minimax để xác định nước đi tốt nhất.
- **Xử lý ngôn ngữ tự nhiên:** Cây cú pháp được sử dụng để phân tích cấu trúc ngữ pháp của câu.
- **Trí tuệ nhân tạo:** Cây quyết định (Decision Tree) được sử dụng trong các thuật toán học máy để phân loại và dự đoán.
- **DOM(Document Object Model):** Cây được sử dụng để biểu diễn cấu trúc của tài liệu HTML và XML trong trình duyệt web.

## 7. Kết luận
- Cây là một cấu trúc dữ liệu mạnh mẽ và linh hoạt, được sử dụng rộng rãi trong nhiều lĩnh vực khác nhau của khoa học máy tính. Hiểu rõ về các loại cây, các thuật ngữ cơ bản, các phương pháp duyệt cây và các thao tác với cây sẽ giúp bạn áp dụng hiệu quả cấu trúc dữ liệu này trong các bài toán thực tế.
- Việc lựa chọn loại cây phù hợp và các thuật toán duyệt cây thích hợp sẽ giúp tối ưu hóa hiệu suất và độ phức tạp của các thao tác trên cây.
- Hãy tiếp tục khám phá và thực hành với các cấu trúc dữ liệu cây để nâng cao kỹ năng lập trình và giải quyết các vấn đề phức tạp trong lĩnh vực khoa học máy tính.