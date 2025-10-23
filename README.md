# RESPONSI 1 MOBILE


## Identitas

* *Nama:* Fawwaz Aufa Al Ghautsa Rafi
* *NIM:* H1D023097
* *Shift Asal:* I
* *Shift Baru:* E

---

## Video Demo Aplikasi

Berikut adalah tautan video demo yang menunjukkan fungsionalitas aplikasi, dimulai dari ikon aplikasi di menu utama.

https://github.com/user-attachments/assets/5394c9cf-b3af-4143-9a38-44f79948471c




---

## Penjelasan Alur Data (API ke Layar)

Alur data pada aplikasi ini dirancang untuk memisahkan logika bisnis dari tampilan, dimulai dari pemanggilan API hingga penyajian data di layar pengguna.

1.  **Dimulai dari Layar (Activity)**
    * Saat pengguna membuka `SquadActivity` atau `CoachActivity`, layar tersebut langsung meminta data ke `MainViewModel` dengan memanggil fungsi `viewModel.fetchTeamDetails(TEAM_ID)`.

2.  **Permintaan Data (ViewModel)**
    * `MainViewModel` menerima permintaan ini. Menggunakan `viewModelScope.launch`, ia menjalankan tugas di *background thread* agar aplikasi tidak *lag*.
    * Di dalam *thread* ini, ViewModel memanggil `RetrofitInstance.api.getTeamDetails(...)` untuk memulai proses pemanggilan ke internet.

3.  **Pemanggilan API (Retrofit)**
    * `RetrofitInstance` adalah objek yang sudah disiapkan untuk terhubung ke `BASE_URL` (dari `Constants.kt`).
    * `RetrofitInstance` menggunakan *interface* `FootballApi` untuk membuat request HTTP GET ke server.
    * Request ini menyertakan `teamId` (yaitu `346`) di dalam URL dan `AUTH_TOKEN` (dari `Constants.kt`) sebagai *Header* otentikasi.

4.  **Menerima Respons (Parsing)**
    * Server API mengirimkan kembali data dalam format JSON.
    * Retrofit, dengan bantuan `GsonConverterFactory`, secara otomatis mengubah data JSON tersebut menjadi objek data Kotlin (seperti `SearchResponse`, `Player`, dan `Coach`).

5.  **Update Data (LiveData)**
    * `MainViewModel` menerima objek `SearchResponse` ini.
    * ViewModel kemudian memperbarui nilai `_teamDetails`, yang merupakan sebuah `LiveData`.

6.  **Menampilkan ke Layar (Observasi)**
    * `SquadActivity` dan `CoachActivity` sedang "mengamati" (`observe`) `LiveData` tersebut.
    * Ketika nilainya berubah (data baru masuk), Activity akan bereaksi:
        * **Di `SquadActivity`:** Data pemain (`squad`) dikirim ke `PlayerAdapter` untuk ditampilkan dalam `RecyclerView`.
        * **Di `CoachActivity`:** Data pelatih (`coach`) diambil dan ditampilkan ke berbagai `TextView` di layar.
