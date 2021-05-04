package com.pragmatists;

import com.pragmatists.domain.Amount;
import com.pragmatists.domain.Transaction;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StatementPrinter {

    public static final String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    private final Console console;

    public StatementPrinter(Console console) {
        this.console = console;
    }

    public void print(List<Transaction> transactionList) {
        printHeader();
        printStatementLinesFor(transactionList);
    }

    private void printHeader() {
        console.printLine(STATEMENT_HEADER);
    }

    private void printStatementLinesFor(List<Transaction> transactionList) {
        statementLines(transactionList).forEach(console::printLine);
    }

    private List<String> statementLines(List<Transaction> transactionList) {
        Amount runningBalance = Amount.amountOf(0);
        return transactionList
                .stream()
                .map(transaction -> statementLine(runningBalance, transaction))
                .sorted(Collections.reverseOrder())
                .collect(toList());
    }

    private String statementLine(Amount runningBalance, Transaction t) {
        runningBalance = runningBalance.plus(t.amount());
        return t.date() + " | " + t.amount() + " | " + runningBalance;
    }
}
