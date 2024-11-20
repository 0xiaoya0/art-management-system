public class ArtPiece {
private ArtPieceContext _fsm;


	public int id;
	public string name;
	public string category;
	public float price;
	public string status;
	public Date creationDate;

	public void appraise() {
		// TODO - implement ArtPiece.appraise
		throw new UnsupportedOperationException();
	}

	public void setPrice() {
		// TODO - implement ArtPiece.setPrice
		throw new UnsupportedOperationException();
	}

	public void sell() {
		// TODO - implement ArtPiece.sell
		throw new UnsupportedOperationException();
	}

    public ArtPiece() {
        _fsm = new ArtPieceContext(this);
    }

    public ArtPieceContext getContext() {
        return _fsm;
    }

    public void authenticated_to_have_value() {
        _fsm.authenticated_to_have_value();
        throw new RuntimeException("Not Implemented!");
    }

    public void recognized_as_unrepairable() {
        throw new RuntimeException("Not Implemented!");
    }

    public void damaged() {
        _fsm.damaged();
        throw new RuntimeException("Not Implemented!");
    }

    public void exhibition_day_arrives() {
        _fsm.exhibition_day_arrives();
        throw new RuntimeException("Not Implemented!");
    }

    public void auction_day_arrives() {
        _fsm.auction_day_arrives();
        throw new RuntimeException("Not Implemented!");
    }

    public void exhibition_ends() {
        _fsm.exhibition_ends();
        throw new RuntimeException("Not Implemented!");
    }

    public void not_sold() {
        _fsm.not_sold();
        throw new RuntimeException("Not Implemented!");
    }

    public void sold() {
        throw new RuntimeException("Not Implemented!");
    }

}