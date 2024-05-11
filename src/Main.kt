//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val ql = QuanLyCBGV()

    val nguoi1 = Nguoi("Nguyễn Văn A", "Hà Nội", "GV001")
    val cbgv1 = CBGV(1000.0, 200.0, 50.0, nguoi1)

    val nguoi2 = Nguoi("Nguyễn Văn B", "Hà Nội", "GV002")
    val cbgv2 = CBGV(2000.0, 300.0, 100.0, nguoi2)

    ql.themCBGV(cbgv1)
    ql.themCBGV(cbgv2)

    ql.xoaCBGV("GV001")

    ql.hienThiDanhSach()
}
