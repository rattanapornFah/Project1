namespace MvcMovie.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddKnowladge1 : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Knowladges",
                c => new
                    {
                        knowladge_ID = c.Int(nullable: false, identity: true),
                        topic = c.String(),
                        detail = c.String(),
                        URL = c.String(),
                    })
                .PrimaryKey(t => t.knowladge_ID);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Knowladges");
        }
    }
}
