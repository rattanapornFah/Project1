namespace MvcMovie.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AddDiabetes : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Diabetes",
                c => new
                    {
                        admin_ID = c.Int(nullable: false, identity: true),
                        admin_name = c.String(),
                        admin_email = c.String(),
                        password = c.String(),
                    })
                .PrimaryKey(t => t.admin_ID);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Diabetes");
        }
    }
}
