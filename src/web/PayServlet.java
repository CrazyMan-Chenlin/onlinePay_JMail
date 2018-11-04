package web;

import util.PaymentUtil;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "PayServlet",urlPatterns = "/PayServlet")
public class PayServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String p0_Cmd = "Buy";
        String p1_MerId = "10001126856";
        String p2_Order = request.getParameter("orderNum");
        String p3_Amt = request.getParameter("amt");
        String p4_Cur = "CNY";
        String p5_Pid = "";
        String p6_Pcat = "";
        String p7_Pdesc = "";
        String p8_Url = request.getContextPath() + "/ResultServlet";
        String p9_SAF = "";
        String pa_MP = "";
        String pd_FrpId = request.getParameter("bank");
        String pr_NeedResponse = "1";
        String keyValue ="69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
        String hamc = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid
                , p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
        request.setAttribute("hmac", hamc);
        /*跳转到jsp页面，再进行提交请求*/
        request.setAttribute("p0_Cmd",p0_Cmd);
        request.setAttribute("p1_MerId",p1_MerId);
        request.setAttribute("p2_Order",p2_Order);
        request.setAttribute("p3_Amt",p3_Amt);
        request.setAttribute("p4_Cur",p4_Cur);
        request.setAttribute("p5_Pid",p5_Pid);
        request.setAttribute("p6_Pcat",p6_Pcat);
        request.setAttribute("p7_Pdesc",p7_Pdesc);
        request.setAttribute("p8_Url",p8_Url);
        request.setAttribute("p9_SAF",p9_SAF);
        request.setAttribute("pa_MP",pa_MP);
        request.setAttribute("pd_FrpId",pd_FrpId);
        request.setAttribute("pr_NeedResponse",pr_NeedResponse);
        request.setAttribute("keyValue",keyValue);
        request.getRequestDispatcher("/confirm.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
         doPost(request,response);
    }
}
