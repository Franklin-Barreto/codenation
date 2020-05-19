package challenge;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

	private final QuoteRepository repository;
	private Random rand = new Random();

	@Autowired
	public QuoteServiceImpl(QuoteRepository repository) {
		this.repository = repository;
	}

	@Override
	public Quote getQuote() {
		int size = (int) this.repository.count();
		return this.repository.findById(rand.nextInt(size)).orElseThrow(() -> new RuntimeException("Record not found"));
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> actors = this.repository.findByActor(actor);

		Collections.shuffle(actors);
		return actors.stream().findAny().get();
	}

}
