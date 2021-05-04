package acceptance;

import com.pragmatists.*;
import com.pragmatists.Console;
import com.pragmatists.domain.Account;
import com.pragmatists.domain.Amount;
import com.pragmatists.domain.Clock;
import com.pragmatists.domain.Transactions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static com.pragmatists.domain.Account.newAccount;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

	@Mock Console console;
	@Mock Clock clock;

	private Account account;

	@Before
	public void initialise() {
		StatementPrinter statementPrinter = new StatementPrinter(console);
		account = newAccount(clock, statementPrinter);
	}

	@Test public void
	should_print_statement_containing_all_transactions() {
		given(clock.date()).willReturn(LocalDate.of(2014,4,1), LocalDate.of(2014,4,2), LocalDate.of(2014,4,10));
		account.deposit(Amount.amountOf(1000));
		account.withdraw(Amount.amountOf(100));
		account.deposit(Amount.amountOf(500));

		account.printStatement();

		verify(console).printLine("DATE | AMOUNT | BALANCE");
		verify(console).printLine("2014-04-10 | 500.00 | 1400.00");
		verify(console).printLine("2014-04-02 | -100.00 | 900.00");
		verify(console).printLine("2014-04-01 | 1000.00 | 1000.00");
	}
}
