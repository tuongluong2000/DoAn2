using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;

namespace ShopUIT.Entities
{
    public class ShopUITDbContext : DbContext
    {
        public DbSet<TaiKhoan> TaiKhoans { get; set; }
        public ShopUITDbContext(DbContextOptions options) : base(options)
        {
        }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<TaiKhoan>().ToTable("TaiKhoan");
        }
    }
}
