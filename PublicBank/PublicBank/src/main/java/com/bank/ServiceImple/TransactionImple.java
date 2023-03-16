package com.bank.ServiceImple;

import com.bank.DTOs.TransActionDTO;
import com.bank.DTOs.ViewDTO.TransActionView;
import com.bank.DTOs.ViewDTO.TransactionsList;
import com.bank.Entity.Account;
import com.bank.Entity.Pots;
import com.bank.Entity.TransActionToAccount;
import com.bank.Entity.Transaction;
import com.bank.ErrorHandler.ErrorMessage;
import com.bank.Filters.TransActionsFilter;
import com.bank.Repository.AccountRepo;
import com.bank.Repository.PotsRepository;
import com.bank.Repository.TransActionToAccountRepo;
import com.bank.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Service
public class TransactionImple   {


    @Autowired
    TransActionToAccountRepo transActionToAccountRepo;
    @Autowired
    PotsRepository potsRepository;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    TransactionRepo transactionRepo;



    public Transaction updateTransAction(TransActionDTO transActionDTO) {

        Transaction t = new Transaction();
        Transaction ts =  transactionRepo.save(t);
        return ts;
    }

    public TransActionView saveTransAction(TransActionDTO transActionDTO){
        TransActionView transActionView = new TransActionView();


        Account fromAccount = accountRepo.findByAccountNumber(transActionDTO.getFromAccount());
        Account toAccount = accountRepo.findByAccountNumber(transActionDTO.getToAccount());
        fromAccount.setBalance(fromAccount.getBalance() - transActionDTO.getTransactionAmount());
        toAccount.setBalance(transActionDTO.getTransactionAmount() + toAccount.getBalance());
        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);


        /*     */
        /*     */


        Transaction transaction = new Transaction();

        transaction.setDiscription(transActionDTO.getDiscription());
        transaction.setFromAccount(fromAccount);
        transaction.setToAccount(toAccount);
        transaction.setBlance(fromAccount.getBalance());
        transaction.setTransactionAmount(transActionDTO.getTransactionAmount());
        transaction.setActive(true);
        transaction.setCustomerId(fromAccount.getId());
        transaction.setTransactionDate(LocalDateTime.now());
        //Transaction.TransActionTypes t = Transaction.TransActionTypes.Debit;
        transaction.setTransActionType(String.valueOf(Transaction.TransActionTypes.Debit));
        transactionRepo.save(transaction);

        /*     */
        /*     */
        TransActionToAccount transActionToAccount = new TransActionToAccount();
        transActionToAccount.setDiscription(transActionDTO.getDiscription());
        transActionToAccount.setFromAccount(fromAccount);
        transActionToAccount.setToAccount(toAccount);
        transActionToAccount.setBlance(fromAccount.getBalance());
        transActionToAccount.setTransactionAmount(transActionDTO.getTransactionAmount());
        transActionToAccount.setActive(true);
        transActionToAccount.setCustomerId(toAccount.getId());
        //Transaction.TransActionTypes t1 = Transaction.TransActionTypes.Credit;
        transActionToAccount.setTransActionType(String.valueOf(Transaction.TransActionTypes.Credit));
        transActionToAccountRepo.save(transActionToAccount);


        /*     */

        /*     */


        transActionView.setDiscription(transActionDTO.getDiscription());
        transActionView.setTransActionId(transaction.getTid());
        transActionView.setTransActionId(transActionView.getTransActionId());
        transActionView.setTransactionAmount(transActionDTO.getTransactionAmount());
        transActionView.setBalance(fromAccount.getBalance());
        transActionView.setTransactionDate(LocalDateTime.now());
        transActionView.setFromAccount(transActionDTO.getFromAccount());
        transActionView.setToAccountNo(transActionDTO.getToAccount());
        transActionView.setCurrentBalance(fromAccount.getBalance());

        /*     */
        /*     */
        int balance = fromAccount.getBalance() - transActionDTO.getTransactionAmount();
       int roundBalance = Math.round(fromAccount.getBalance() - transActionDTO.getTransactionAmount()) - balance;
        //Pots pots =  potsRepository.findByAccountNumber(transActionDTO.getToAccount());
        Pots pots;
        if(potsRepository.findByAccountNumber(transActionDTO.getFromAccount()) == null){
             pots = new Pots();
            pots.setId(pots.getId());
            pots.setPotBalance(roundBalance);
            pots.setAccount(fromAccount);
            pots.setAccountNumber(fromAccount.getAccountNumber());
            potsRepository.save(pots);
        }
        else {

            pots = potsRepository.findByAccountNumber(transActionDTO.getFromAccount());

            pots.setPotBalance(pots.getPotBalance()+roundBalance);
           potsRepository.save(pots);

        }
        /* */

        /* */

        return transActionView;
    }

    public List<TransActionsFilter> getAllTransAction(List<Transaction> transactions) {
        List<TransActionsFilter> transActionsFilters =new ArrayList<>();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        transactions.stream().forEach(trans->{
            TransActionsFilter filter = new TransActionsFilter();
            filter.setAccountHolderName(trans.getFromAccount().getCustomer().getName());
            filter.setAccountNumber(trans.getFromAccount().getAccountNumber());
            filter.setDate(trans.getTransactionDate().format(myFormatObj));
            filter.setTransActionAmount(trans.getTransactionAmount());
            filter.setDescription(trans.getDiscription());
            transActionsFilters.add(filter);
        });
//        for (Transaction transaction : transactions) {
//            TransActionsFilter transActionsFilter = new TransActionsFilter();
//            transActionsFilter.setAccountHolderName(transaction.getFromAccount().getCustomer().getName());
//            transActionsFilter.setAccountNumber(transaction.getFromAccount().getAccountNumber());
//            transActionsFilter.setDate((transaction.getTransactionDate()).format(myFormatObj));
//            transActionsFilter.setTransActionAmount(transaction.getTransactionAmount());
//            transActionsFilter.setDescription(transaction.getDiscription());
//            transActionsFilters.add(transActionsFilter);
//        }

        return transActionsFilters;
    }

    //here Description in Compulsory
    public Object getAllImplementation(TransActionsFilter transActionsFilter) {
        TransactionsList transactionsList = new TransactionsList();
        if(transActionsFilter.getDescription().equals("Paytm") ||transActionsFilter.getDescription().equals("GPay")
                ||(transActionsFilter.getDescription().equals("Deposit")) ) {

            if (transActionsFilter.getTransActionAmount() != 0 && transActionsFilter.getAccountNumber() != 0 && transActionsFilter.getDescription() != null) {
                List<Transaction> transactionList = transactionRepo.findByFromAccount_AccountNumberAndTransactionAmountAndDiscriptionOrderByTransactionDateDesc(
                        transActionsFilter.getAccountNumber(),
                        transActionsFilter.getTransActionAmount(),
                        transActionsFilter.getDescription()
                );
                List<TransActionsFilter> getTransActionWithOutAccountHolderNameName =getAllTransAction(
                        transactionList
                );

                transactionsList.setTransactionsList(getTransActionWithOutAccountHolderNameName);

                return transactionsList;
            } else if (transActionsFilter.getAccountNumber() == 0 && transActionsFilter.getTransActionAmount() == 0) {
                List<TransActionsFilter> getWithOutAccountNumberAndTransactionAmount = getAllTransAction
                        (transactionRepo.findByDiscriptionOrderByTransactionDateDesc(transActionsFilter.getDescription()));
                transactionsList.setTransactionsList(getWithOutAccountNumberAndTransactionAmount);
                return transactionsList;
            } else if (transActionsFilter.getAccountNumber() == 0 && transActionsFilter.getDescription() == null) {
                List<TransActionsFilter> getTransactionWithOutDescriptionAndAmount = getAllTransAction(transactionRepo.
                        findByTransactionAmountOrderByTransactionDateDesc(transActionsFilter.getTransActionAmount()));
                transactionsList.setTransactionsList(getTransactionWithOutDescriptionAndAmount);
                return transactionsList;
            } else if (transActionsFilter.getTransActionAmount() == 0 && transActionsFilter.getDescription() == null) {
                List<TransActionsFilter> getAll = getAllTransAction(transactionRepo.findAll());
                transactionsList.setTransactionsList(getAll);
                return transactionsList;
            } else if (transActionsFilter.getDescription() == null) {
                List<TransActionsFilter> getTransactionWithOutDescription = getAllTransAction(transactionRepo.
                        findByTransactionAmountAndFromAccount_AccountNumberOrderByTransactionDateDesc(transActionsFilter.getTransActionAmount(),
                                transActionsFilter.getAccountNumber()));
                transactionsList.setTransactionsList(getTransactionWithOutDescription);
                return transactionsList;
            } else if (transActionsFilter.getTransActionAmount() == 0) {
                List<TransActionsFilter> getTransactionWithOutAmount =
                        getAllTransAction(transactionRepo.findByFromAccount_AccountNumberAndDiscriptionOrderByTransactionDateDesc
                                (transActionsFilter.getAccountNumber(), transActionsFilter.getDescription()));
                transactionsList.setTransactionsList(getTransactionWithOutAmount);
                return transactionsList;
            } else if (transActionsFilter.getAccountNumber() == 0) {


                List<TransActionsFilter> getWithoutAccountNumber =
                        getAllTransAction(transactionRepo.findByTransactionAmountAndDiscriptionOrderByTransactionDateDesc
                                (transActionsFilter.getTransActionAmount(),
                                        transActionsFilter.getDescription()));
                transactionsList.setTransactionsList(getWithoutAccountNumber);
                //transactionsList.setTransactionsList(getWithoutAccountNumber);
                return transactionsList;
            } else {
                List<TransActionsFilter> getAll = getAllTransAction(transactionRepo.findByFromAccount_AccountNumber(transActionsFilter.getAccountNumber()));
                transactionsList.setTransactionsList(getAll);
                return transactionsList;
            }
        }
        else return new ErrorMessage("not Linked");

    }

    public TransactionsList getAllTransActions(TransActionsFilter transActionsFilter){
        TransactionsList transactionsList = new TransactionsList();

        if(transActionsFilter.getTransActionAmount()==0&& transActionsFilter.getDescription()==null){
                // List <Transaction> transaction = transactionRepo.findByFromAccount_AccountNumber(transActionsFilter.getAccountNumber());

         List<TransActionsFilter> transActionsFilters =   getAllTransAction(
                 transactionRepo.findByFromAccount_AccountNumber(transActionsFilter.getAccountNumber()));
         transactionsList.setTransactionsList(transActionsFilters);
         return transactionsList;
        }

         if(transActionsFilter.getTransActionAmount()==0){
//
        List<TransActionsFilter> transActionsFilters =    getAllTransAction(transactionRepo.findByFromAccount_AccountNumberAndDiscriptionOrderByTransactionDateDesc
                    (transActionsFilter.getAccountNumber(),transActionsFilter.getDescription()));
            transactionsList.setTransactionsList(transActionsFilters);
            return transactionsList;
        }
        else if(transActionsFilter.getDescription()==null){
            List<TransActionsFilter> transActionsFilters =  getAllTransAction ( transactionRepo.findByTransactionAmountAndFromAccount_AccountNumberOrderByTransactionDateDesc(
                    transActionsFilter.getTransActionAmount(),transActionsFilter.getAccountNumber()));
            transactionsList.setTransactionsList(transActionsFilters);
            return  transactionsList;
        }
        else {
            List<TransActionsFilter> transActionsFilters = getAllTransAction(
                    transactionRepo.findByFromAccount_AccountNumber(transActionsFilter.getAccountNumber()));
            transactionsList.setTransactionsList(transActionsFilters);
            return transactionsList;
        }
    }

















}
