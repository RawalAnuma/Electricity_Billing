package service;

import com.demo.billing.model.BillRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.BillRecordRepository;
import java.util.List;

@Service
public class BillRecordService {

    @Autowired
    BillRecordRepository billRecordRepository;

    public boolean insertBillRecord(BillRecords billRecords){
        billRecordRepository.save(billRecords);
        return true;
    }

    public List<BillRecords> getAllBillRecords(){
        return billRecordRepository.findAll();
    }

    public BillRecords getHighestPayingCustomer() {
        return billRecordRepository.findTopByOrderByBillAmountDesc();
    }
}
