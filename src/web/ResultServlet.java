package web;

import util.PaymentUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResultServlet",urlPatterns = "/ResultServlet")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html;utf-8");
        String hmac = request.getParameter("hmac");
        String p1_merId = request.getParameter("p1_MerId");
        String r0_cmd = request.getParameter("r0_Cmd");
        String r1_code = request.getParameter("r1_Code");
        String r2_trxId = request.getParameter("r2_TrxId");
        String r3_amt = request.getParameter("r3_Amt");
        String r4_cur = request.getParameter("r4_Cur");
        String r5_pid = request.getParameter("r5_Pid");
        String r6_order = request.getParameter("r6_Order");
        String r7_uid = request.getParameter("r7_Uid");
        String r8_mp = request.getParameter("r8_MP");
        String r9_bType = request.getParameter("r9_BType");
        boolean result = PaymentUtil.verifyCallback(hmac, p1_merId, r0_cmd, r1_code, r2_trxId, r3_amt, r4_cur, r5_pid,
                r6_order, r7_uid, r8_mp, r9_bType, "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl");
        if (result){
            response.getWriter().write("成功！");
        }else{
            response.getWriter().write("失败！");
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
