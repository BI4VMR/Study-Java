package net.bi4vmr.study;

/**
 * TODO 添加描述。
 * <p>
 * TODO 添加详情。
 *
 * @author BI4VMR@outlook.com
 * @since 1.0.0
 */
public class LoanCalculator2 {
    public static void main(String[] args) {
        // 定义贷款金额、年利率和贷款期限
        double loanAmount = 497161.09; // 贷款金额（元）
        double annualInterestRate = 0.03; // 年利率（5%）
        int loanTerm = 297; // 贷款期限（12个月）

        // 计算月利率
        double monthlyInterestRate = annualInterestRate / 12; // 月利率

        // 等额本金还款方式
        System.out.println("等额本金还款方式：");
        for (int month = 1; month <= loanTerm; month++) {
            double principal = loanAmount / loanTerm; // 每月还款的本金
            double interest = (loanAmount - (principal * (month - 1))) * monthlyInterestRate; // 剩余贷款计算利息
            double totalPayment = principal + interest; // 总还款额
            System.out.printf("第%d个月：还款 %.2f 元 (本金 %.2f 元 + 利息 %.2f 元)%n", month, totalPayment, principal, interest);
        }

        // // 等额本息还款方式
        // System.out.println("等额本息还款方式：");
        // double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTerm))
        //         / (Math.pow(1 + monthlyInterestRate, loanTerm) - 1); // 每月还款额
        //
        // for (int month = 1; month <= loanTerm; month++) {
        //     double interest = loanAmount * monthlyInterestRate; // 当月应还利息
        //     double principal = monthlyPayment - interest; // 当月应还本金
        //     loanAmount -= principal; // 更新剩余贷款金额
        //     System.out.printf("第%d个月：还款 %.2f 元 (本金 %.2f 元 + 利息 %.2f 元)%n",
        //             month, monthlyPayment, principal, interest);
        // }
    }
}
