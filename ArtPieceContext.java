import java.io.PrintStream;

public final class ArtPieceContext
    extends FSMContext
{
//---------------------------------------------------------------
// Member methods.
//

    public ArtPieceContext(ArtPiece owner)
    {
        super();

        _owner = owner;
        setState(ArtPieceFSM.In_storage);
        ArtPieceFSM.In_storage.Entry(this);
    }

    public synchronized void auction_day_arrives()
    {
        _transition = "auction_day_arrives";
        getState().auction_day_arrives(this);
        _transition = "";
        return;
    }

    public synchronized void authenticated_to_have_value()
    {
        _transition = "authenticated_to_have_value";
        getState().authenticated_to_have_value(this);
        _transition = "";
        return;
    }

    public synchronized void damaged()
    {
        _transition = "damaged";
        getState().damaged(this);
        _transition = "";
        return;
    }

    public synchronized void exhibition_day_arrives()
    {
        _transition = "exhibition_day_arrives";
        getState().exhibition_day_arrives(this);
        _transition = "";
        return;
    }

    public synchronized void exhibition_ends()
    {
        _transition = "exhibition_ends";
        getState().exhibition_ends(this);
        _transition = "";
        return;
    }

    public synchronized void not_sold()
    {
        _transition = "not_sold";
        getState().not_sold(this);
        _transition = "";
        return;
    }

    public synchronized void recognized_as_unrepairable()
    {
        _transition = "recognized_as_unrepairable";
        getState().recognized_as_unrepairable(this);
        _transition = "";
        return;
    }

    public synchronized void repaired()
    {
        _transition = "repaired";
        getState().repaired(this);
        _transition = "";
        return;
    }

    public synchronized void sold()
    {
        _transition = "sold";
        getState().sold(this);
        _transition = "";
        return;
    }

    public ArtPieceState getState()
        throws StateUndefinedException
    {
        if (_state == null)
        {
            throw(
                new StateUndefinedException());
        }

        return ((ArtPieceState) _state);
    }

    protected ArtPiece getOwner()
    {
        return (_owner);
    }

//---------------------------------------------------------------
// Member data.
//

    transient private ArtPiece _owner;

//---------------------------------------------------------------
// Inner classes.
//

    public static abstract class ArtPieceState
        extends State
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected ArtPieceState(String name, int id)
        {
            super (name, id);
        }

        protected void Entry(ArtPieceContext context) {}
        protected void Exit(ArtPieceContext context) {}

        protected void auction_day_arrives(ArtPieceContext context)
        {
            Default(context);
        }

        protected void authenticated_to_have_value(ArtPieceContext context)
        {
            Default(context);
        }

        protected void damaged(ArtPieceContext context)
        {
            Default(context);
        }

        protected void exhibition_day_arrives(ArtPieceContext context)
        {
            Default(context);
        }

        protected void exhibition_ends(ArtPieceContext context)
        {
            Default(context);
        }

        protected void not_sold(ArtPieceContext context)
        {
            Default(context);
        }

        protected void recognized_as_unrepairable(ArtPieceContext context)
        {
            Default(context);
        }

        protected void repaired(ArtPieceContext context)
        {
            Default(context);
        }

        protected void sold(ArtPieceContext context)
        {
            Default(context);
        }

        protected void Default(ArtPieceContext context)
        {
            if (context.getDebugFlag() == true)
            {
                PrintStream str = 
                    context.getDebugStream();

                str.println(
                    "TRANSITION   : Default");
            }

            throw (
                new TransitionUndefinedException(
                    "State: " +
                    context.getState().getName() +
                    ", Transition: " +
                    context.getTransition()));
        }

    //-----------------------------------------------------------
    // Member data.
    //
    }

    /* package */ static abstract class ArtPieceFSM
    {
    //-----------------------------------------------------------
    // Member methods.
    //

    //-----------------------------------------------------------
    // Member data.
    //

        //-------------------------------------------------------
        // Statics.
        //
        public static ArtPieceFSM_Default.ArtPieceFSM_Preview Preview;
        public static ArtPieceFSM_Default.ArtPieceFSM_Damaged_State Damaged_State;
        public static ArtPieceFSM_Default.ArtPieceFSM_Settlement Settlement;
        public static ArtPieceFSM_Default.ArtPieceFSM_On_show On_show;
        public static ArtPieceFSM_Default.ArtPieceFSM_Final Final;
        public static ArtPieceFSM_Default.ArtPieceFSM_On_auction On_auction;
        public static ArtPieceFSM_Default.ArtPieceFSM_Arrangement Arrangement;
        public static ArtPieceFSM_Default.ArtPieceFSM_Out_side_of_collection Out_side_of_collection;
        public static ArtPieceFSM_Default.ArtPieceFSM_In_storage In_storage;
        public static ArtPieceFSM_Default.ArtPieceFSM_In_the_art_collection In_the_art_collection;
        public static ArtPieceFSM_Default.ArtPieceFSM_Reserved reserved;
        private static ArtPieceFSM_Default Default;

        static
        {
            Preview = new ArtPieceFSM_Default.ArtPieceFSM_Preview("ArtPieceFSM.Preview", 0);
            Damaged_State = new ArtPieceFSM_Default.ArtPieceFSM_Damaged_State("ArtPieceFSM.Damaged_State", 1);
            Settlement = new ArtPieceFSM_Default.ArtPieceFSM_Settlement("ArtPieceFSM.Settlement", 2);
            On_show = new ArtPieceFSM_Default.ArtPieceFSM_On_show("ArtPieceFSM.On_show", 3);
            Final = new ArtPieceFSM_Default.ArtPieceFSM_Final("ArtPieceFSM.Final", 4);
            On_auction = new ArtPieceFSM_Default.ArtPieceFSM_On_auction("ArtPieceFSM.On_auction", 5);
            Arrangement = new ArtPieceFSM_Default.ArtPieceFSM_Arrangement("ArtPieceFSM.Arrangement", 6);
            Out_side_of_collection = new ArtPieceFSM_Default.ArtPieceFSM_Out_side_of_collection("ArtPieceFSM.Out_side_of_collection", 7);
            In_storage = new ArtPieceFSM_Default.ArtPieceFSM_In_storage("ArtPieceFSM.In_storage", 8);
            In_the_art_collection = new ArtPieceFSM_Default.ArtPieceFSM_In_the_art_collection("ArtPieceFSM.In_the_art_collection", 9);
            reserved = new ArtPieceFSM_Default.ArtPieceFSM_Reserved("ArtPieceFSM.Reserved", 10);
            Default = new ArtPieceFSM_Default("ArtPieceFSM.Default", -1);
        }

    }

    protected static class ArtPieceFSM_Default
        extends ArtPieceState
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected ArtPieceFSM_Default(String name, int id)
        {
            super (name, id);
        }

    //-----------------------------------------------------------
    // Inner classse.
    //


        private static final class ArtPieceFSM_Preview
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_Preview(String name, int id)
            {
                super (name, id);
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_Damaged_State
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_Damaged_State(String name, int id)
            {
                super (name, id);
            }

            protected void recognized_as_unrepairable(ArtPieceContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : ArtPieceFSM.Damaged_State.recognized_as_unrepairable()");
                }


                (context.getState()).Exit(context);
                context.setState(ArtPieceFSM.Final);
                (context.getState()).Entry(context);
                return;
            }

            protected void repaired(ArtPieceContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : ArtPieceFSM.Damaged_State.repaired()");
                }


                (context.getState()).Exit(context);
                context.setState(ArtPieceFSM.In_the_art_collection);
                (context.getState()).Entry(context);
                return;
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_Settlement
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_Settlement(String name, int id)
            {
                super (name, id);
            }

            protected void not_sold(ArtPieceContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : ArtPieceFSM.Settlement.not_sold()");
                }


                (context.getState()).Exit(context);
                context.setState(ArtPieceFSM.In_storage);
                (context.getState()).Entry(context);
                return;
            }

            protected void sold(ArtPieceContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : ArtPieceFSM.Settlement.sold()");
                }


                (context.getState()).Exit(context);
                context.setState(ArtPieceFSM.Final);
                (context.getState()).Entry(context);
                return;
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_On_show
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_On_show(String name, int id)
            {
                super (name, id);
            }

            protected void exhibition_ends(ArtPieceContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : ArtPieceFSM.On_show.exhibition_ends()");
                }


                (context.getState()).Exit(context);
                context.setState(ArtPieceFSM.In_storage);
                (context.getState()).Entry(context);
                return;
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_Final
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_Final(String name, int id)
            {
                super (name, id);
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_On_auction
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_On_auction(String name, int id)
            {
                super (name, id);
            }

            protected void auction_day_arrives(ArtPieceContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : ArtPieceFSM.On_auction.auction_day_arrives()");
                }


                (context.getState()).Exit(context);
                context.setState(ArtPieceFSM.Settlement);
                (context.getState()).Entry(context);
                return;
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_Arrangement
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_Arrangement(String name, int id)
            {
                super (name, id);
            }

            protected void exhibition_day_arrives(ArtPieceContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : ArtPieceFSM.Arrangement.exhibition_day_arrives()");
                }


                (context.getState()).Exit(context);
                context.setState(ArtPieceFSM.On_show);
                (context.getState()).Entry(context);
                return;
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_Out_side_of_collection
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_Out_side_of_collection(String name, int id)
            {
                super (name, id);
            }

            protected void authenticated_to_have_value(ArtPieceContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : ArtPieceFSM.Out_side_of_collection.authenticated_to_have_value()");
                }


                (context.getState()).Exit(context);
                context.setState(ArtPieceFSM.In_the_art_collection);
                (context.getState()).Entry(context);
                return;
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_In_storage
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_In_storage(String name, int id)
            {
                super (name, id);
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_In_the_art_collection
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_In_the_art_collection(String name, int id)
            {
                super (name, id);
            }

            protected void damaged(ArtPieceContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : ArtPieceFSM.In_the_art_collection.damaged()");
                }


                (context.getState()).Exit(context);
                context.setState(ArtPieceFSM.Damaged_State);
                (context.getState()).Entry(context);
                return;
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class ArtPieceFSM_Reserved
            extends ArtPieceFSM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private ArtPieceFSM_Reserved(String name, int id)
            {
                super (name, id);
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

    //-----------------------------------------------------------
    // Member data.
    //
    }
}
