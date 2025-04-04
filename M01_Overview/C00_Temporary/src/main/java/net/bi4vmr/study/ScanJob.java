package net.bi4vmr.study;

/**
 * Name        : ScanJob
 * <p>
 * Author      : BI4VMR
 * <p>
 * Email       : bi4vmr@outlook.com
 * <p>
 * Date        : 2025-04-04 18:11
 * <p>
 * Description : TODO 添加描述
 */
/**
 * 扫描任务类，执行具体的扫描任务
 */
public class ScanJob implements Runnable{
    // 扫描信息
    private ScanObject object;
    // 扫描类型
    private String scanType;

    public ScanJob(ScanObject object,String scanType) {
        this.object = object;
        this.scanType = scanType;

    }

    @Override
    public void run() {
        ScanEngine.scan(object, scanType);
    }
}

