### App.java
didalam kelas ini terdapat pernyataan `import com.layouts.Menu;`. Ini adalah pernyataan impor yang mengimport kelas `Menu` dari paket `com.layouts`. Dengan mengimport kelas `Menu`, 
  kita dapat menggunakan fungsi `showMenu()` yang ada di dalamnya.
- Pada baris ke-4, terdapat deklarasi kelas `App` dengan kata kunci `public`. Ini berarti kelas `App` dapat diakses dari luar paket.
- Pada baris ke-5, terdapat method `main(String[] args)`. Method ini merupakan titik masuk utama dari program. Ketika program dijalankan, eksekusi akan dimulai dari method `main`. 
  Parameter `String[] args` adalah parameter yang dapat digunakan untuk menerima argumen baris perintah jika diperlukan.
- Pada baris ke-6, terdapat pernyataan `Menu.showMenu();`. Ini adalah pemanggilan method `showMenu()` dari kelas `Menu`. Dengan memanggil method ini, program akan menampilkan menu 
  aplikasi yang ditampilkan di kelas `Menu` dan pengguna dapat memilih opsi yang diinginkan.
- Jadi, pada saat program dijalankan, menu aplikasi akan ditampilkan menggunakan method `showMenu()` dari kelas `Menu`.

### MyConfig.java
- didalam config terdapat myconfig Kelas ini bertanggung jawab untuk mengatur konfigurasi dan koneksi ke database MySQL.
- Pada baris ke-3 hingga ke-9, terdapat beberapa import statement yang digunakan untuk mengimpor kelas-kelas yang diperlukan dalam kode ini, seperti Connection, DriverManager,   
  PreparedStatement, dan ResultSet dari paket java.sql.
- DB_URL: URL koneksi ke database. Dalam kode ini, URL koneksi adalah "jdbc:mysql://localhost:3306/db_product", yang mengindikasikan bahwa database MySQL berada di localhost  
  pada port 3306 dengan nama database "db_product".
- DB_USER: Nama pengguna (username) yang digunakan untuk mengakses database. Dalam kode ini, pengguna adalah "root".
- DB_PASS: Kata sandi (password) yang digunakan untuk mengakses database. Dalam kode ini, tidak ada kata sandi yang ditentukan.
- Terdapat variabel statis connect, preparedStatement, resultSet, dan query yang digunakan untuk menyimpan koneksi ke database, objek PreparedStatement, objek ResultSet, dan query \  
  SQL yang akan dieksekusi.
- Method connection() digunakan untuk melakukan koneksi ke database. Pada baris ke-19, DriverManager.getConnection(DB_URL, DB_USER, DB_PASS) digunakan untuk mendapatkan objek  
  Connection yang mewakili koneksi ke database menggunakan URL, nama pengguna, dan kata sandi yang telah ditentukan sebelumnya. Jika koneksi berhasil, pesan "Sudah TerConnect database Cuy Sukses" akan ditampilkan di konsol. Jika terjadi SQLException, maka pesan kesalahan akan dicetak di konsol.
- Dengan menggunakan kelas MyConfig ini, Anda dapat memanggil method connection() untuk menghubungkan aplikasi Anda ke database MySQL dengan menggunakan konfigurasi yang telah  
  ditentukan.

### ControllerDB.java
didalam file controller Kelas ini merupakan turunan dari kelas `MyConfig` dan berfungsi sebagai pengontrol interaksi antara aplikasi dengan database.
- Pada baris ke-3 hingga ke-9, terdapat beberapa import statement yang digunakan untuk mengimpor kelas-kelas yang diperlukan dalam kode ini, seperti `SQLException`, `MyConfig`, dan 
 `Produk`.
- Kelas `ControllerDB` merupakan turunan dari kelas `MyConfig`, yang artinya kelas ini dapat mengakses dan menggunakan variabel dan method yang ada di kelas `MyConfig`.
- Method `getDatabase()` digunakan untuk mengambil data dari tabel `tb_product` dalam database. Pada baris ke-11, method `connection()` dari kelas `MyConfig` dipanggil untuk membuat 
  koneksi ke database. Kemudian, query SQL yang akan dieksekusi adalah "SELECT NAMA, HARGA, JUMLAH FROM `tb_product` ORDER BY ID DESC". Hasil dari query tersebut disimpan dalam objek `resultSet`, dan kemudian diiterasi menggunakan `while (resultSet.next())` untuk mencetak data NAMA, HARGA, dan JUMLAH ke konsol. Setelah selesai, objek `preparedStatement` ditutup pada baris ke-21.
- Method `insertDB()` digunakan untuk memasukkan data baru ke dalam tabel `tb_product` dalam database. Pada baris ke-28, method `connection()` dari kelas `MyConfig` dipanggil untuk 
  membuat koneksi ke database. Query SQL yang akan dieksekusi adalah "INSERT INTO `tb_product` (NAMA, HARGA, JUMLAH) VALUES (?, ?, ?)". Nilai-nilai parameter yang diperlukan (product, i, stok) ditetapkan menggunakan `preparedStatement.setString()`, `preparedStatement.setLong()`, dan `preparedStatement.setInt()`. Setelah itu, query dieksekusi menggunakan `preparedStatement.executeUpdate()`. Jika operasi berhasil, method akan mengembalikan nilai `true`. Jika terjadi `SQLException`, pesan kesalahan akan dicetak dan method akan mengembalikan nilai `false`.
- Terdapat beberapa method lainnya seperti `updateNamaDB()`, `updateHargaDB()`, `updateStokDB()`, dan `deletDB()` yang digunakan untuk melakukan pembaruan dan penghapusan data dalam 
  tabel `tb_product` berdasarkan ID atau NAMA.
- Method `getProdukbyNama()` digunakan untuk mendapatkan data produk berdasarkan nama. Pada baris ke-83, method `connection()` dari kelas `MyConfig` dipanggil untuk membuat koneksi 
  ke database. Query SQL yang akan dieksekusi adalah "SELECT * FROM `tb_product` WHERE NAMA=?". Nilai parameter yang diperlukan (nama) ditetapkan menggunakan `preparedStatement.setString()`. Hasil dari query tersebut disimpan dalam objek `resultSet`. Jika ada hasil yang ditemukan, objek `Produk` dibuat menggunakan data dari `resultSet`. Method akan mengembalikan objek `Produk` tersebut.
- Dengan menggunakan kelas `ControllerDB` ini, Anda dapat mengakses dan mengelola data dalam tabel `tb_product` dalam database menggunakan operasi seperti mengambil data, memasukkan 
  data baru, memperbarui data, dan menghapus data.

### DeleteData.java
ini didalam layouts Pada baris ke-3 hingga ke-5, terdapat beberapa import statement yang digunakan untuk mengimpor kelas-kelas yang diperlukan dalam kode ini, seperti `Scanner` dan `ControllerDB`.
- Method `showDeleteData()` digunakan untuk menampilkan menu penghapusan data dan menghapus data dari tabel `tb_product` dalam database. Pada baris ke-7 hingga ke-13, terdapat 
  beberapa pernyataan `System.out.println()` yang mencetak pesan-pesan teks untuk menampilkan menu penghapusan data. Kemudian, method `getDatabase()` dari kelas `ControllerDB` dipanggil pada baris ke-14 untuk menampilkan data yang ada dalam tabel `tb_product`. Setelah itu, pengguna diminta untuk memasukkan nama produk yang ingin dihapus melalui `Scanner` pada baris ke-17 dan ke-18. Jika `ControllerDB.deletDB(nama)` mengembalikan nilai `true`, maka pesan "BERHASIL MENGHAPUS DATA" ditampilkan. Jika tidak, pesan "GAGAL MENGHAPUS DATA" ditampilkan, dan method `showDeleteData()` dipanggil kembali untuk menampilkan menu penghapusan data.
- Setelah penghapusan data selesai, pada baris ke-24, method `showMenu()` dari kelas `Menu` dipanggil untuk menampilkan menu utama aplikasi.
- Pada baris ke-25, `sc.close()` digunakan untuk menutup objek `Scanner` setelah penggunaan selesai.
- Dengan menggunakan kelas `DeleteData` ini, pengguna dapat menampilkan menu penghapusan data, memasukkan nama produk yang ingin dihapus, dan melakukan penghapusan data dari tabel `
  `tb_product` dalam database.

### InsertData.java
didalam file layout terdaoat insertdata dimana Pada baris ke-3 hingga ke-5, terdapat beberapa import statement yang digunakan untuk mengimpor kelas-kelas yang diperlukan dalam kode ini, seperti `Scanner` dan `ControllerDB`.
- Method `showInsertData()` digunakan untuk menampilkan menu penambahan data dan memasukkan data baru ke dalam tabel `tb_product` dalam database. Pada baris ke-7 hingga ke-23, 
  terdapat serangkaian pernyataan `System.out.println()` dan `Scanner` yang digunakan untuk meminta pengguna memasukkan data produk seperti nama, harga, dan stok. Nilai-nilai ini akan disimpan dalam variabel `name`, `harga`, dan `stok`. Setelah pengguna memasukkan data, method `insertDB(name, harga, stok)` dari kelas `ControllerDB` dipanggil pada baris ke-13 untuk memasukkan data ke dalam tabel `tb_product`. Jika operasi berhasil, pesan "BERHASIL INSERT DATA" akan ditampilkan. Jika tidak, pesan "GAGAL MENAMBAHKAN DATA" akan ditampilkan.
- Setelah penambahan data selesai, pada baris ke-18, method `showMenu()` dari kelas `Menu` dipanggil untuk menampilkan menu utama aplikasi.
- Pada baris ke-19, `sc.close()` digunakan untuk menutup objek `Scanner` setelah penggunaan selesai.
- Terdapat blok `catch` pada baris ke-8 hingga ke-16 yang menangkap `Exception`. Jika terjadi `Exception`, maka method `showInsertData()` akan dipanggil kembali untuk mengulangi 
  proses penambahan data.
- Dengan menggunakan kelas `InsertData` ini, pengguna dapat menampilkan menu penambahan data, memasukkan data produk seperti nama, harga, dan stok, dan melakukan penambahan data baru 
  ke dalam tabel `tb_product` dalam database.

### Menu.java
didalam file terdapat Menu java dimana dalamnya Method `showMenu()` digunakan untuk menampilkan menu utama aplikasi. Pada baris ke-3 hingga ke-11, terdapat serangkaian pernyataan `System.out.println()` yang mencetak pesan-pesan 
  teks untuk menampilkan menu pilihan yang tersedia. Setelah itu, method `SelectMenu()` dipanggil pada baris ke-12 untuk memproses pilihan menu yang diambil oleh pengguna.
- Method `SelectMenu()` digunakan untuk memproses pilihan menu yang diambil oleh pengguna. Pada baris ke-14 hingga ke-40, terdapat blok `switch` yang memeriksa nilai `menu` yang 
  diinputkan oleh pengguna. Jika nilai `menu` sesuai dengan salah satu pilihan, maka method terkait akan dipanggil, seperti `ReadData.showReadData()` untuk menampilkan data, `InsertData.showInsertData()` untuk memasukkan data, `UpdateData.showUpdateData(null)` untuk mengedit data, dan `DeleteData.showDeleteData()` untuk menghapus data. Jika nilai `menu` adalah 5, maka pesan "SAMPAI JUMPA KEMBALI..." ditampilkan. Jika nilai `menu` tidak sesuai dengan pilihan yang ada, pesan "MAAF MENU TIDAK ADA DIPILIHAN" ditampilkan, dan   
   method `showMenu()` dipanggil kembali untuk menampilkan menu utama aplikasi.
- Pada baris ke-43, `sc.close()` digunakan untuk menutup objek `Scanner` setelah penggunaan selesai.
- Terdapat blok `catch` pada baris ke-17 hingga ke-28 yang menangkap `Exception`. Jika terjadi `Exception`, maka pesan "INPUTAN HARUS ANGKA BANG" ditampilkan, dan method `showMenu()` 
  dipanggil kembali untuk menampilkan menu utama aplikasi.
- Dengan menggunakan kelas `Menu` ini, pengguna dapat menampilkan menu utama aplikasi, memilih opsi menu yang tersedia, dan melanjutkan ke operasi yang sesuai berdasarkan pilihan 
  yang dibuat.

### ReadData.java
didalam file layouts terdapat Read data.java dimana Pada baris ke-3 hingga ke-5, terdapat beberapa import statement yang digunakan untuk mengimpor kelas-kelas yang diperlukan dalam kode ini, seperti `Scanner` dan `ControllerDB`.
- Method `showReadData()` digunakan untuk menampilkan data produk yang ada dalam tabel `tb_product`. Pada baris ke-7 hingga ke-10, terdapat pernyataan `System.out.println()` yang   
  mencetak pesan-pesan teks untuk menampilkan judul "DATA PRODUK BANG". Kemudian, pada baris ke-11, `ControllerDB.getDatabase()` dipanggil untuk mendapatkan data produk dari tabel `tb_product` dengan memanggil method `getDatabase()` dari kelas `ControllerDB`.
- Pada baris ke-13, terdapat pernyataan `System.out.println()` yang mencetak pemisah garis horizontal. Pada baris ke-15 hingga ke-16, terdapat pernyataan `System.out.println()` yang 
  menampilkan pilihan menu, yaitu "1. MENU" dan "2. EXIT". Pada baris ke-17, `System.out.print()` digunakan untuk mencetak pesan "Pilih bang: " untuk meminta pengguna memilih menu.
- Pada baris ke-19 hingga ke-49, terdapat blok `try-catch` yang digunakan untuk menangani inputan dari pengguna. Pada baris ke-21, `int selectMenu = sc.nextInt()` digunakan untuk 
  membaca inputan angka dari pengguna. Kemudian, pada blok `switch` yang dimulai pada baris ke-23, nilai `selectMenu` akan diperiksa. Jika nilai `selectMenu` adalah 1, maka method `Menu.showMenu()` akan dipanggil untuk menampilkan menu utama aplikasi. Jika nilai `selectMenu` adalah 2, maka pesan "SAMPAI JUMPA KEMBALI..." akan ditampilkan dan program akan dihentikan menggunakan `System.exit()`. Jika nilai `selectMenu` tidak sesuai dengan pilihan yang ada, pesan "MAAF MENU YANG DIPILIH TIDAK TERSEDIA" ditampilkan, dan method `showReadData()` dipanggil kembali untuk menampilkan data produk dan meminta pengguna memilih menu.
- Pada baris ke-43 hingga ke-52, terdapat blok `catch` yang menangkap `Exception`. Jika terjadi `Exception`, maka pesan "MASUKKAN INPUTAN ANGKA BANG" ditampilkan, dan method 
 `showReadData()` dipanggil kembali untuk menampilkan data produk dan meminta pengguna memilih menu.
- Pada baris ke-57, `Menu.showMenu()` dipanggil untuk menampilkan menu utama aplikasi setelah proses penampilan data selesai.
- Pada baris ke-58, `sc.close()` digunakan untuk menutup objek `Scanner` setelah penggunaan selesai.
- Dengan menggunakan kelas `ReadData` ini, pengguna dapat menampilkan data produk yang ada dalam tabel `tb_product` dari database

### UpdateData.java
didalam file layouts terdapat update.java dimana Pada baris ke-3 hingga ke-6, terdapat beberapa import statement yang digunakan untuk mengimpor kelas-kelas yang diperlukan dalam kode ini, seperti `Scanner`, `ControllerDB`, dan 
 `Produk`.
- Method `showUpdateData(String nama)` digunakan untuk menampilkan menu pilihan pembaruan data produk dan memproses pembaruan sesuai dengan pilihan pengguna. Pada baris ke-8 hingga \ 
  ke-10, terdapat pernyataan `System.out.println()` yang mencetak pesan-pesan teks untuk menampilkan judul "SILAHKAN PILIH DATA YANG INGIN DIEDIT". Kemudian, pada baris ke-11, `ControllerDB.getDatabase()` dipanggil untuk mendapatkan data produk dari tabel `tb_product` dengan memanggil method `getDatabase()` dari kelas `ControllerDB`.
- Pada baris ke-13, terdapat pernyataan `System.out.println()` yang mencetak pemisah garis horizontal. Pada baris ke-15 hingga ke-19, terdapat pernyataan `System.out.println()` yang 
  menampilkan menu pilihan pembaruan, yaitu "1. UPDATE NAMA", "2. UPDATE HARGA", dan "3. UPDATE JUMLAH". Pada baris ke-21, `System.out.print()` digunakan untuk mencetak pesan "Pilih Menu Produk Makanan: " untuk meminta pengguna memilih menu.
- Pada baris ke-23 hingga ke-58, terdapat blok `try-catch` yang digunakan untuk menangani inputan dari pengguna dan memproses pembaruan data produk sesuai dengan pilihan pengguna. 
  Pada baris ke-25, `int selectMenu = sc.nextInt()` digunakan untuk membaca inputan angka dari pengguna. Kemudian, pada blok `switch` yang dimulai pada baris ke-27, nilai `selectMenu` akan diperiksa. Jika nilai `selectMenu` adalah 1, maka method `showEditNama(nama)` akan dipanggil untuk memperbarui nama produk. Jika nilai `selectMenu` adalah 2, maka method `showEditHarga(nama)` akan dipanggil untuk memperbarui harga produk. Jika nilai `selectMenu` adalah 3, maka method `showEditStok(nama)` akan dipanggil untuk memperbarui jumlah stok produk. Jika nilai `selectMenu` tidak sesuai dengan pilihan yang ada, pesan "MAAF NAMA YANG DIPILIH TIDAK TERSEDIA" ditampilkan, dan method `Menu.showMenu()` dipanggil untuk menampilkan menu utama aplikasi.
- Pada baris ke-60 hingga ke-69, terdapat method `showEditNama(String nama)` yang digunakan untuk memperbarui nama produk. Method ini menerima parameter `nama` yang akan digunakan 
  untuk mengidentifikasi produk yang akan diperbarui. Pada baris ke-62, `Produk produk = ControllerDB.getProdukbyNama(nama)` digunakan untuk mendapatkan objek `Produk` berdasarkan nama produk yang diberikan. Kemudian, pada baris ke-64, pesan "NAMA AWAL: " beserta nama produk yang awal ditampilkan. Pada baris ke-66, `String namaBaru = sc.nextLine()` digunakan untuk membaca inputan string dari pengguna yang merupakan nama baru untuk produk. Kemudian, `ControllerDB.updateNamaDB(produk.getId(), namaBaru)` dipanggil untuk memperbarui nama produk dalam database menggunakan method `updateNamaDB()` dari kelas `ControllerDB`. Pesan "BERHASIL UPDATE DATA NAMA" ditampilkan, dan method `Menu.showMenu()` dipanggil untuk menampilkan menu utama aplikasi.
- Pada baris ke-71 hingga ke-80, terdapat method `showEditHarga(String nama)` yang digunakan untuk memperbarui harga produk. Cara kerjanya mirip dengan method `showEditNama()`, 
  tetapi kali ini harga produk yang akan diperbarui. Pada baris ke-76, `long hargaBaru = sc.nextInt()` digunakan untuk membaca inputan angka dari pengguna yang merupakan harga baru untuk produk.
- Pada baris ke-82 hingga ke-91, terdapat method `showEditStok(String nama)` yang digunakan untuk memperbarui jumlah stok produk. Cara kerjanya mirip dengan method `showEditNama()`, 
  tetapi kali ini jumlah stok produk yang akan diperbarui. Pada baris ke-87, `int stokBaru = sc.nextInt()` digunakan untuk membaca inputan angka dari pengguna yang merupakan jumlah stok baru untuk produk. Dalam semua method `showEditNama()`, `showEditHarga()`, dan `showEditStok()`, setelah pembaruan data produk dilakukan, pesan yang sesuai ditampilkan dan method `Menu.showMenu()` dipanggil untuk menampilkan menu utama aplikasi.
- Pada baris ke-93, `sc.close()` digunakan untuk menutup objek `Scanner` setelah penggunaan selesai.
- Dengan menggunakan kelas `UpdateData` ini, pengguna dapat memilih produk yang ingin diperbarui dan memilih opsi pembaruan yang diinginkan, seperti nama produk, harga produk, dan 
  jumlah stok produk.


### Produk.java
didalam models terdapat ptoduk.java dimana didalamnya Pada baris ke-3 hingga ke-8, terdapat deklarasi atribut-atribut kelas `id`, `nama`, `harga`, dan `stok`. Atribut-atribut ini akan digunakan untuk menyimpan informasi tentang 
  produk, seperti ID produk, nama produk, harga produk, dan jumlah stok produk. Atribut-atribut ini bersifat private, artinya hanya dapat diakses oleh kelas `Produk` itu sendiri.
- Pada baris ke-10 hingga ke-17, terdapat constructor `Produk(int id, String nama, long harga, int stok)`. Constructor ini digunakan untuk membuat objek `Produk` dengan 
  menginisialisasi nilai-nilai awal dari atribut-atribut kelas. Parameter-parameter yang diberikan pada constructor ini akan digunakan untuk mengisi nilai-nilai atribut-atribut tersebut.
- Pada baris ke-19 hingga ke-24, terdapat beberapa method getter dan setter. Method getter digunakan untuk mendapatkan nilai dari atribut-atribut kelas, sedangkan method setter 
  digunakan untuk mengubah nilai dari atribut-atribut kelas. Misalnya, method `getId()` digunakan untuk mendapatkan nilai atribut `id`, dan method `setId(int id)` digunakan untuk mengubah nilai atribut `id`.
- Dengan adanya kelas `Produk` ini, kita dapat membuat objek `Produk` yang berisi informasi tentang suatu produk. Objek ini dapat digunakan untuk menyimpan dan mengakses informasi 
  produk tersebut, seperti ID, nama, harga, dan stok.

